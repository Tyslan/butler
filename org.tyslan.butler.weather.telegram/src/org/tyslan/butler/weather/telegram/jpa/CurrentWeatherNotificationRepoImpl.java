package org.tyslan.butler.weather.telegram.jpa;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jdbc.DataSourceFactory;
import org.osgi.service.jpa.EntityManagerFactoryBuilder;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.transaction.control.TransactionControl;
import org.osgi.service.transaction.control.jpa.JPAEntityManagerProviderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.weather.telegram.CurrentWeatherTelegramJob;

@Component(immediate = true)
@Designate(ocd = RepoConfig.class)
public class CurrentWeatherNotificationRepoImpl implements CurrentWeatherNotificationRepo {
  private static final Logger logger =
      LoggerFactory.getLogger(CurrentWeatherNotificationRepoImpl.class);

  @Reference
  private TransactionControl txControl;
  @Reference
  private DataSourceFactory dsf;
  @Reference
  private EntityManagerFactoryBuilder emfb;
  @Reference
  private JPAEntityManagerProviderFactory providerFactory;
  private EntityManager em;

  @Activate
  public void activate(RepoConfig config) throws SQLException {
    Properties jdbcProps = new Properties();
    jdbcProps.put("url", config.getUrl());
    jdbcProps.put("user", config.getUsername());
    jdbcProps.put("password", config.getPassword());

    Map<String, Object> jpaProps = new HashMap<>();
    jpaProps.put("javax.persistence.nonJtaDataSource", dsf.createDataSource(jdbcProps));
    em = providerFactory.getProviderFor(emfb, jpaProps, null).getResource(txControl);
    logger.trace("CurrentWeatherNotificationRepoImpl started.");
  }

  @Override
  public void save(CurrentWeatherTelegramJob job) {
    txControl.required(() -> {
      if (job == null) {
        throw new IllegalArgumentException("Cannot persist null.");
      }
      if (job.getId() == null) {
        em.persist(job);
      } else {
        em.merge(job);
      }
      logger.trace("Saved {}.", job);
      return null;
    });

  }

  @Override
  public void delete(long id) {
    txControl.required(() -> {
      CriteriaBuilder builder = em.getCriteriaBuilder();
      CriteriaDelete<CurrentWeatherTelegramJob> query =
          builder.createCriteriaDelete(CurrentWeatherTelegramJob.class);
      Root<CurrentWeatherTelegramJob> from = query.from(CurrentWeatherTelegramJob.class);
      query.where(builder.equal(from.get("id"), id));
      int deleted = em.createQuery(query).executeUpdate();
      logger.trace("Deleted {} records.", deleted);
      return null;
    });

  }

  @Override
  public List<CurrentWeatherTelegramJob> getAll() {
    return txControl.notSupported(() -> {
      CriteriaBuilder builder = em.getCriteriaBuilder();
      CriteriaQuery<CurrentWeatherTelegramJob> query =
          builder.createQuery(CurrentWeatherTelegramJob.class);
      return em.createQuery(query).getResultList();
    });
  }
}
