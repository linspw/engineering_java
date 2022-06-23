import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ListaEncadeadaDupla.ListaEncadeadaDupla;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
  private JFrame screen;
  private Container body;
  private CardLayout navigation;
  private String username;
  private Integer gameGrids = 2;
  private Integer gameRoundTime;
  private ArrayList<Integer> gameRoundGrid;
  private Timer gameRoundTimer;
  private ArrayList<String> players = new ArrayList<String>();
  private Card selectedCard;

  final static String MENU_STEP = "Menu Step";
  final static String ADD_USERNAME_STEP = "Add Username Step";
  final static String CHOICE_DIFICULT_STEP = "Choice Dificult Step";
  final static String GAME_STEP = "Game Step";
  final static String RANKING_STEP = "Ranking Step";


  Game() {
    this.screen = new JFrame("Jogo da Memória");
    this.screen.setBounds(50, 100, 800, 800);
    this.screen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    CardLayout stepLayout = new CardLayout();

    this.navigation = stepLayout;
    this.body = this.screen.getContentPane();
    this.body.setLayout(this.navigation);

    this.body.add(menuStep(), MENU_STEP);
    this.body.add(addUserNameStep(), ADD_USERNAME_STEP);
    this.body.add(choiceDificultStep(), CHOICE_DIFICULT_STEP);
    this.body.add(gameStep(), GAME_STEP);
    this.body.add(rankingStep(), RANKING_STEP);

    this.screen.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    this.screen.setUndecorated(true);
    this.screen.setVisible(true);
  }

  private JPanel menuStep() {
    JPanel step = new JPanel();
    GridLayout stepLayout = new GridLayout(3, 1);
    JLabel title = new JLabel("Jogo da memória", SwingConstants.CENTER);
    JPanel menu = new JPanel(new GridLayout(0, 1, 20, 30));
    JButton option1 = new JButton("Iniciar");
    JButton option2 = new JButton("Ranking");
    JButton option3 = new JButton("Sair");
    JPanel container = new JPanel(new FlowLayout());

    step.setLayout(stepLayout);
    step.add(title);

    title.setFont(new Font("Verdana", Font.BOLD, 32));

    option1.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        navigation.show(body, ADD_USERNAME_STEP);
      }  
    });

    option2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        navigation.show(body, RANKING_STEP);
      }
    });

    option3.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        System.exit(0);
      }  
    });

    menu.add(option1);
    menu.add(option2);
    menu.add(option3);

    container.add(menu);
    container.setSize(400, 400); 

    step.add(container);
    return step;
  }

  private JPanel addUserNameStep() {
    Step step = new Step(ADD_USERNAME_STEP);
    GridLayout stepLayout = new GridLayout(3, 1);
    JLabel title = new JLabel("Adicione o nome de usuário:", SwingConstants.CENTER);
    JPanel container = new JPanel(new FlowLayout());
    
    JButton addUserButton = new JButton("Adicionar");
    JTextField txtInput = new JTextField(10);

    step.setLayout(stepLayout);
    title.setFont(new Font("Verdana", Font.BOLD, 32));
    step.add(title);

    addUserButton.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        username = txtInput.getText();
        System.out.println(username);
        if(username != null && !username.equals("")) navigation.show(body, CHOICE_DIFICULT_STEP);
      }  
    });

    container.add(txtInput);
    container.add(addUserButton);
    step.add(container);
    return step;
  }

  private JPanel choiceDificultStep() {
    JPanel step = new JPanel();
    GridLayout stepLayout = new GridLayout(3, 1);
    JLabel title = new JLabel("Selecione a dificuldade", SwingConstants.CENTER);
    JPanel menu = new JPanel(new GridLayout(0, 1, 20, 30));
    JButton option1 = new JButton("Fácil");
    JButton option2 = new JButton("Intermediário");
    JButton option3 = new JButton("Dificíl");
    JPanel container = new JPanel(new FlowLayout());

    step.setLayout(stepLayout);
    step.add(title);

    title.setFont(new Font("Verdana", Font.BOLD, 32));

    option1.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        gameGrids = 2;
        navigation.show(body, GAME_STEP);
      }  
    });

    option2.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        gameGrids = 4;
        navigation.show(body, GAME_STEP);
      }  
    });

    option3.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
        gameGrids = 6;
        navigation.show(body, GAME_STEP);
      }  
    });

    menu.add(option1);
    menu.add(option2);
    menu.add(option3);

    container.add(menu);
    container.setSize(400, 400); 

    step.add(container);
    return step;
  }

  private JPanel rankingStep() {
    Step step = new Step(RANKING_STEP);

    step.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentHidden(ComponentEvent evt) {
        step.cleanContainer();
      }
      @Override
      public void componentShown(ComponentEvent evt) {
        step.setTitle("Ranking");
        step.initContainer();
        step.cleanContainer();

        JPanel menu = new JPanel(new GridLayout(1, 0));

        for (int index = 0; index < players.size(); index++) {
          JLabel element = new JLabel(players.get(index));

          menu.add(element);
        }

        JButton sair = new JButton("Sair");
        sair.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e ) {
            navigation.show(body, MENU_STEP);
          }
        });
        menu.add(sair);

        step.addContainer(menu);
      }
  });

    return step;
  }

  private JPanel gameStep() {
    Step step = new Step(GAME_STEP);

    step.addComponentListener(new ComponentAdapter() {
      @Override
      public void componentHidden(ComponentEvent evt) {
        step.cleanContainer();
      }
      @Override
      public void componentShown(ComponentEvent evt) {
        step.setTitle("Jogando " + gameRoundTime);
        gameRoundTime = 0;
        gameRoundTimer = new Timer();
        gameRoundTimer.scheduleAtFixedRate(new TimerTask() {
          public void run() {
            gameRoundTime += 1;
            step.setTitle("Jogando... Tempo: " + gameRoundTime);
          }
        }, 0, 1000);
    
        step.initContainer();
        step.cleanContainer();

        ListaEncadeadaDupla lista = UniqueRandomNumbers.get(gameGrids);
        gameRoundGrid = new ArrayList<Integer>();

        GridLayout layout = new GridLayout(0, gameGrids, 20, 30);
        JPanel menu = new JPanel(layout);

        int numOfGrids = (gameGrids * gameGrids);
        System.out.println(numOfGrids);
        for (int index = 0; index < numOfGrids; index++) {
          System.out.println("numOfGrids" + index);
          int image = (int) lista.pega(index);
          JButton element = getItem(image, index, step);
          menu.add(element);
        }
        menu.list();
        step.addContainer(menu);
      }
  });

    return step;
  }

  private JButton getItem(int image, int index, Step step) {
    JButton element = new JButton("");
    element.setPreferredSize(new Dimension(80, 80));
    String resource = "/images/icon"+ image + ".png";
    
    element.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        element.setIcon(new ImageIcon(this.getClass().getResource(resource)));

        int result = gameRoundGrid.indexOf(image);
        if (result != -1) return;

        if (selectedCard == null) {
          selectedCard = new Card(image, index, element);
        } else if (selectedCard.position != index && selectedCard.image == image) {
          gameRoundGrid.add(image);
          selectedCard = null;
        } else {
          Card current = selectedCard;
          selectedCard = null;

          element.setBackground(Color.RED);
          current.element.setBackground(Color.RED);
          // selectedCard.element.setOpaque(true);
          // element.setOpaque(true);
          Timer timer = new Timer();
          timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
              current.element.setIcon(null);
              current.element.setBackground(null);
              element.setIcon(null);
              element.setBackground(null);
              timer.cancel();
            }
          }, 2000, 3000);

        }

        if (gameRoundGrid.size() >= ((gameGrids * gameGrids) / 2)) {
          gameRoundTimer.cancel();
          float score = (float)gameRoundTime / (float)gameGrids;
          step.setTitle("Ganhou!! Pontuação: "+ score + " (Tempo " + gameRoundTime + "s / " + "dificuldade "+ gameGrids + ")");
          JButton sair = new JButton("Sair");
          sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ) {
              navigation.show(body, MENU_STEP);
            }
          });
          Timer timer = new Timer();
          timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
              step.cleanContainer();
              step.addContainer(sair);
              players.add(username + " - " + score + "  (Tempo " + gameRoundTime + "s / " + "dificuldade "+ gameGrids + ")");
              timer.cancel();
            }
          }, 2000, 3000);
        }
      }  
    });

    return element;
  }
}