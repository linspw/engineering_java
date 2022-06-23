import javax.swing.*;

public class Card {
  int image;
  int position;
  JButton element;

  Card(int image, int position, JButton element) {
    this.image = image;
    this.position = position;
    this.element = element;
  }
}
