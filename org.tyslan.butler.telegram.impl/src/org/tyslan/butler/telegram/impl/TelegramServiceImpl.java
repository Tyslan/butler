package org.tyslan.butler.telegram.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tyslan.butler.telegram.impl.abs.UpdateReceiver;
import org.tyslan.butler.telegram.impl.receiver.LongPollingSession;
import org.tyslan.butler.telegram.meta.methods.GetMe;
import org.tyslan.butler.telegram.meta.methods.SendMessage;
import org.tyslan.butler.telegram.meta.types.Update;
import org.tyslan.butler.telegram.meta.types.User;
import org.tyslan.butler.telegram.meta.types.message.Message;

@Component(immediate = true)
@Designate(ocd = TelegramServiceConfig.class)
public class TelegramServiceImpl {
  private static final Logger logger = LoggerFactory.getLogger(TelegramServiceImpl.class);
  private LongPollingSession session;

  @Activate
  protected void activate(TelegramServiceConfig config) {
    try {
      MethodExecutor sender = new MethodExecutor(config.getBotToken());
      User user = sender.execute(new GetMe());
      System.out.println(user);
      Message message = sender.execute(new SendMessage(720574480l, "Hello World"));
      UpdateReceiver receiver = new UpdateReceiver() {

        @Override
        public void getBotUsername() {
          // TODO Auto-generated method stub

        }

        @Override
        public void onUpdateReceived(Update update) {
          // TODO Auto-generated method stub

        }
      };
      LongPollingSession session = new LongPollingSession(config.getBotToken(), receiver);
      session.start();
      System.out.println(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Deactivate
  protected void deactivate() {
    session.stop();
  }
}
