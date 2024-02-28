package Adventure_game;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerDetails, retreat;
	JLabel titleNameLabel, hpLabel, hpLabelCount, weaponLabel, weaponLableName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 85);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea, extraText;
	int playerHp;
	String power, position;

	TitleScreenHandler Handler = new TitleScreenHandler();
	choiceHandler HandlerNew = new choiceHandler();

	public static void main(String[] args) {

		new Game();
	}

	public Game() {
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);

		con = window.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.black);

		titleNameLabel = new JLabel("Adventure Game");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.black);

		startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);

		startButton.addActionListener(Handler);
		startButton.setFocusPainted(false);

		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);

		con.add(titleNamePanel);
		con.add(startButtonPanel);

		window.setLayout(null);
		window.setVisible(true);

	}

	public void createGameScreen() {
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);

		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);

		mainTextArea = new JTextArea();
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.red);
		choiceButtonPanel.setLayout(new GridLayout(4, 1));
		con.add(choiceButtonPanel);

		choice1 = new JButton("Choice1");
		choice1.setFocusPainted(false);
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.addActionListener(HandlerNew);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("Choice2");
		choice2.setFocusPainted(false);
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.addActionListener(HandlerNew);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		choice3 = new JButton("Choice3");
		choice3.setFocusPainted(false);
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.addActionListener(HandlerNew);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);

		choice4 = new JButton("Choice4");
		choice4.setFocusPainted(false);
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.addActionListener(HandlerNew);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);

		playerDetails = new JPanel();
		playerDetails.setBounds(100, 15, 500, 50);
		playerDetails.setBackground(Color.black);
		playerDetails.setLayout(new GridLayout(1, 4));
		con.add(playerDetails);

		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.white);
		playerDetails.add(hpLabel);
		hpLabelCount = new JLabel();
		hpLabelCount.setFont(normalFont);
		hpLabelCount.setForeground(Color.white);
		playerDetails.add(hpLabelCount);

		weaponLabel = new JLabel("Power:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.white);
		playerDetails.add(weaponLabel);
		weaponLableName = new JLabel();
		weaponLableName.setFont(normalFont);
		weaponLableName.setForeground(Color.white);
		playerDetails.add(weaponLableName);

		playerSetup();
	}

	public void playerSetup() {
		playerHp = 15;
		power = "??";
		weaponLableName.setText(power);
		hpLabelCount.setText("" + playerHp);

		MainScreen();
	}

	public void MainScreen() {
		position = "raceSelect";
		mainTextArea.setText("Welcome to the world of Fantasy.\nSelect the Race that you want to Join.");
		choice1.setText("Angels");
		choice2.setText("Demons");
		choice3.setText("Humans");
		choice4.setText("Monster");

	}

	public void SecondMainScreen() {
		position = "SecondMainScreenSection";
		mainTextArea.setText("You have Gained Hp:" + playerHp + "and your power is:" + power);
		choice1.setText("Do nothing.");
		choice2.setText("Attack Demons");
		choice3.setText("Attack monsters");
		choice4.setText("Retreat");
	}

	public void thirdMainScreen() {
		position = "MainScreenSection";
		mainTextArea.setText("You have Gained Hp:" + playerHp + "and your power is:" + power);
		choice1.setText("Do nothing.");
		choice2.setText("Attack Angels");
		choice3.setText("Attack monsters");
		choice4.setText("Retreat");
	}

	public void retreat() {
		position = "retreat";
		retreat = new JPanel();
		retreat.setBounds(100, 15, 500, 50);
		retreat.setBackground(Color.red);
		retreat.setLayout(new GridLayout(1, 4));
		con.add(retreat);

		mainTextArea.setText("You Have Been Defeated\n GAMEOVER");
		choice1.setText("RESTART");
		choice2.setText("EXIT GAME");
		choice3.setText("");
		choice4.setText("");
	}

	public void doNothing() {
		playerDetails.setVisible(false);
		choiceButtonPanel.setVisible(false);
		mainTextArea.setText("The World Has Ended!!!");
		mainTextArea.setBackground(Color.red);
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.add(extraText);
	}

	public void Angels() {
		position = "angelScreen";
		power = "BasicMagic";
		weaponLableName.setText(power);
		hpLabelCount.setText("" + playerHp);
		mainTextArea.setText(
				"Embrace the divine as a holy angel. Gain \"Holy Magic\" and help humanity.\n Beware, demons might see you as a threat.");
		choice1.setText("Learn holy powers");
		choice2.setText("Build Churches");
		choice3.setText("Feed people");
		choice4.setText("Quit");
	}

	public void learnHolyPowers() {
		position = "learnHolyPowerssection";
		mainTextArea.setText("You learnt the holy magic, power and HP\n increases!!!");
		playerHp = playerHp + 20;
		hpLabelCount.setText("" + playerHp);
		power = "Holy Magic";
		weaponLableName.setText(power);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Back");
	}

	public void Demons() {
		position = "demonScreen";
		power = "Dark Magic";
		weaponLableName.setText(power);
		hpLabelCount.setText("" + playerHp);
		mainTextArea.setText(
				" Embrace darkness as a mighty devil with Dark Magic.\n Dominate others, but humans may unite against you.");
		choice1.setText("Learn dark magic");
		choice2.setText("Kill humans and spread Havoc");
		choice3.setText("Dominate other races");
		choice4.setText("Quit");
	}

	public void demondeeds() {
		mainTextArea.setText("You learnt and used dark magic power and HP\\n increases!!!");
		playerHp = playerHp + 50;
		hpLabelCount.setText("" + playerHp);
		power = "Necromancer";
		weaponLableName.setText(power);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Back");
	}

	public void Humans() {
		position = "humanScreen";
		power = "swordlord";
		weaponLableName.setText(power);
		hpLabelCount.setText("" + playerHp);
		mainTextArea.setText(
				"Be a brave hero, the \"Swordlord.\"\n Defend against demons,but monsters may challenge your dominance.");
		choice1.setText("Go to Hero's Academy");
		choice2.setText("Kill demons and monsters who spread havoc");
		choice3.setText("Enjoy life peacefully");
		choice4.setText("Quit");
	}

	public void humandeeds() {
		mainTextArea.setText("You have learnt the true issence of being a human, power and HP\\\\n increases!!!");
		playerHp = playerHp + 5;
		hpLabelCount.setText("" + playerHp);
		power = "TrueHero";
		weaponLableName.setText(power);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Back");
	}

	public void Monsters() {
		position = "monsterScreen";
		power = "BeastLord";
		weaponLableName.setText(power);
		hpLabelCount.setText("" + playerHp);
		mainTextArea.setText(
				"Become a strong monster with \"BeastLord\" powers.\n Invade humans,but angels may stand against your horde.");
		choice1.setText("Monster do not interfere in others matter");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Quit");
	}

	public void monsterdeeds() {
		mainTextArea.setText("You have became a monster with no intelligence. No change in power and HP!");
		playerHp = playerHp + 5;
		hpLabelCount.setText("" + playerHp);
		power = "TrueHero";
		weaponLableName.setText(power);
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("Back");
	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			createGameScreen();
		}
	}

	public class choiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();

			switch (position) {
			case "raceSelect":
				switch (yourChoice) {
				case "c1":
					Angels();
					break;
				case "c2":
					Demons();
					break;
				case "c3":
					Humans();
					break;
				case "c4":
					Monsters();
					break;
				}
				break;

			case "angelScreen":
				switch (yourChoice) {
				case "c1":
					learnHolyPowers();
					break;
				case "c2":
					learnHolyPowers();
					break;
				case "c3":
					learnHolyPowers();
					break;
				case "c4":
					MainScreen();
					break;
				}
				break;
			case "demonScreen":
				switch (yourChoice) {
				case "c1":
					demondeeds();
					break;
				case "c2":
					demondeeds();
					break;
				case "c3":
					demondeeds();
					break;
				case "c4":
					MainScreen();
					break;
				}
				break;
			case "humanScreen":
				switch (yourChoice) {
				case "c1":
					humandeeds();
					break;
				case "c2":
					humandeeds();
					break;
				case "c3":
					humandeeds();
					break;
				case "c4":
					MainScreen();
					break;
				}
				break;
			case "monsterScreen":
				switch (yourChoice) {
				case "c1":
					monsterdeeds();
					break;
				case "c2":
					monsterdeeds();
					break;
				case "c3":
					monsterdeeds();
					break;
				case "c4":
					MainScreen();
					break;
				}
				break;

			case "learnHolyPowerssection":
				switch (yourChoice) {
				case "c4":
					SecondMainScreen();
				}
				break;

			case "demondeeds":
				switch (yourChoice) {
				case "c4":
					thirdMainScreen();
				}
				break;

			case "humandeeds":
				switch (yourChoice) {
				case "c4":
					SecondMainScreen();
				}
				break;

			case "SecondMainScreenSection": {
				switch (yourChoice) {
				case "c1":
					doNothing();
					break;
				case "c4":
					retreat();
					break;
				}
			}
			case "retreat":
				switch (yourChoice) {
				case "c1":
					MainScreen();
					break;
				}

			}
		}
	}

}
