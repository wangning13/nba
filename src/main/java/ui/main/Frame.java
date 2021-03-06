package ui.main;

import java.awt.CardLayout;

import javax.swing.*;

import ui.match.MatchLive;
import ui.match.Matches;
import ui.match.SingleMatch;
import ui.player.PlayerAnalyze;
import ui.player.PlayersCompare;
import ui.player.PlayersSelect;
import ui.player.SinglePlayer;
import ui.player.Statistics;
import ui.team.PlayOff;
import ui.team.Ranking;
import ui.team.Refer;
import ui.team.SingleTeam;
import ui.team.TeamAnalyze;
import ui.team.TeamsCompare;
import ui.team.TeamsSelect;

@SuppressWarnings("serial")
public class Frame extends JFrame {

	public static final int WIN_W = 1052;
	public static final int WIN_H = 650;
	public static Ranking rankingPanel;
	public static Statistics statisticsPanel ;
	public static MainFrame mainFrame ;
	public static TeamsSelect teamsSelectPanel ;
	public static PlayersSelect playersSelectPanel;
	public static SingleTeam singleTeamPanel ;
	public static SinglePlayer singlePlayerPanel;
	public static Matches matchesPanel ;
	public static SingleMatch singleMatchPanel;
	public static PlayersCompare playersComparePanel;
	public static PlayerAnalyze playerAnalyzePanel;
	public static TeamAnalyze teamAnalyzePanel;
//	public static MatchLive matchLivePanel;
	public static PlayOff playOffPanel;
	public static TeamsCompare teamsComparePanel;
	public static Refer referPanel;
	public static String currentPanel = "main";

	public Frame() {
		super("NBA数据控");
		
		rankingPanel = new Ranking(this);
	    statisticsPanel = new Statistics(this);
		mainFrame = new MainFrame(this);
		teamsSelectPanel = new TeamsSelect(this);
		playersSelectPanel = new PlayersSelect(this);
		singleTeamPanel = new SingleTeam(this);
		singlePlayerPanel = new SinglePlayer(this);
		matchesPanel = new Matches(this);
		singleMatchPanel = new SingleMatch(this);
		playersComparePanel = new PlayersCompare(this);
		playerAnalyzePanel = new PlayerAnalyze(this);
		teamAnalyzePanel = new TeamAnalyze(this);
	//	matchLivePanel = new MatchLive(this);
		playOffPanel = new PlayOff(this);
		teamsComparePanel = new TeamsCompare(this);
		referPanel = new Refer(this);
		
		this.getContentPane().add(mainFrame);
		CardLayout cl = new CardLayout();
		this.setLayout(cl);

		this.setSize(WIN_W, WIN_H);
		this.setLocationRelativeTo(null);// 使窗口位于屏幕中央
		this.setUndecorated(true);// 只有在窗体不可显示时才调用此方法
		this.setResizable(false); // 去除窗口栏 (目前暂时保留以供调试方便)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
/*
	public static void update() {
		if (currentPanel.equals("ranking")) {
			rankingPanel.update();
		} else if (currentPanel.equals("statistics")) {
			statisticsPanel.update();
		} 
		  else if (currentPanel.equals("playersSelect")) {
			playersSelectPanel.update();
		} 
		  else if (currentPanel.equals("singleTeam")) {
			singleTeamPanel.update();
		} else if (currentPanel.equals("singlePlayer")) {
			singlePlayerPanel.update();
		} else if (currentPanel.equals("matches")) {
			matchesPanel.update();
		}
	}*/

	public void change(JPanel cur, JPanel next) {
		cur.setVisible(false);
		this.remove(cur);
		System.gc();
		next.setVisible(true);
		add(next);
		next.setBounds(0, 0, 1052, 650);
		repaint();
	}

}
