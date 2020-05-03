package org.tyslan.butler.telegram.meta.types.message;

public enum ParseMode {
  HTML("HTML"), MARKDOWN("Markdown"), MARKDOWN_V2("MarkdownV2");

  private final String textualRepresentation;

  ParseMode(String text) {
    this.textualRepresentation = text;
  }

  @Override
  public String toString() {
    return textualRepresentation;
  }
}
