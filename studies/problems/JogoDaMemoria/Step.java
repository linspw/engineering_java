import java.awt.*;
import javax.swing.*;

class Step extends JPanel {
  private String panelName;
  private GridBagLayout stepLayout;
  private JLabel title;
  private JPanel container;

  public Step(String panelName) {
      this.panelName = panelName;
      this.stepLayout = new GridBagLayout();

      this.setLayout(stepLayout);
  }

  public void setTitle(String titleName) {
    if (this.title == null) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridheight = 1;
      this.title = new JLabel(titleName, SwingConstants.CENTER);
      this.title.setFont(new Font("Verdana", Font.BOLD, 32));
      this.add(title, gbc);
    } else {
      this.title.setText(titleName);
    }
  }

  public void initContainer() {
    if (this.container == null) {
      GridBagConstraints gbc2 = new GridBagConstraints();
      gbc2.gridx = 0;
      gbc2.gridy = 1;
      gbc2.fill = GridBagConstraints.VERTICAL;
      this.container = new JPanel(new FlowLayout());
      container.setSize(800, 800);
      this.add(this.container, gbc2);
    }
  }

  public void cleanContainer() {
    if (this.container != null) {
      this.container.removeAll();
      this.container.revalidate();
      this.container.repaint();
    }
  }

  public void addContainer(Component component) {
    this.container.add(component);
  }

  public void start() {
    System.out.println(panelName + " started");
  }

  public void stop() {
    if (this.container != null) this.container.removeAll();
    System.out.println(panelName + " stopped");
  }
}