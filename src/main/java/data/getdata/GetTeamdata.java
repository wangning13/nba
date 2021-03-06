package data.getdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import po.TeamMatchPO;
import po.TeamPO;
import po.TeaminfoPO;
import data.initial.InitialDatabase;
import dataservice.getdatadataservice.GetTeamdataDataService;

public class GetTeamdata implements GetTeamdataDataService {

	Statement statement;

	public GetTeamdata() {
		try {
			Class.forName(InitialDatabase.driver);
			Connection conn = DriverManager.getConnection(InitialDatabase.url,InitialDatabase.user,InitialDatabase.password);
			statement = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TeaminfoPO getTeaminfo(String teamName) {
		TeaminfoPO po = null;
		try {
			ResultSet rs = statement.executeQuery(SqlStatement
					.getTeaminfo(teamName));
			while (rs.next())
				po = new TeaminfoPO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<String> getTeamPlayer(String season, String teamName) {
		ArrayList<String> teamPlayer = new ArrayList<String>();
		String sql = "SELECT playerName FROM `playersum" + season
				+ "` where team='" + teamName + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
				teamPlayer.add(rs.getString(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teamPlayer;
	}

	public TeamPO getTeamdata(String season, String teamName) {
		int opponentFieldGoal = 0;// 对手投篮命中数
		int opponentFieldGoalAttempts = 0;// 对手投篮出手次数
		int opponentTurnOver = 0;// 对手失误数
		int opponentFreeThrowAttempts = 0;// 对手罚球数
		int oppenentScoring = 0;// 对手得分
		int matches = 0;// 比赛场数
		int wins = 0;// 胜利场数
		int fieldGoal = 0;// 投篮命中数
		int fieldGoalAttempts = 0;// 投篮出手次数
		int threePointFieldGoal = 0;// 三分命中数
		int threePointFieldGoalAttempts = 0;// 三分出手数
		int freeThrow = 0;// 罚球命中数
		int freeThrowAttempts = 0;// 罚球出手数
		int offensiveRebound = 0;// 进攻篮板数
		int defensiveRebound = 0;// 防守篮板数
		int opponentOffensiveRebound = 0;// 对手进攻篮板数
		int opponentDefensiveRebound = 0;// 对手防守篮板数
		int backboard = 0;// 篮板数
		int assist = 0;// 助攻数
		int steal = 0;// 抢断数
		int block = 0;// 盖帽数
		int turnOver = 0;// 失误数
		int foul = 0;// 犯规数
		int scoring = 0;// 比赛得分
		double fieldGoalPercentage = 0;// 投篮命中率
		double threePointShotPercentage = 0;// 三分命中率
		double freeThrowPercentage = 0;// 三分命中率
		double winningPercentage = 0;// 胜率
		double possessions = 0;// 进攻回合
		double offensiveEfficiency = 0;// 进攻效率
		double defensiveEfficiency = 0;// 防守效率
		double offensivebackboardEfficiency = 0;// 进攻篮板效率
		double defensivebackboardEfficiency = 0;// 防守篮板效率
		double stealEfficiency = 0;// 抢断效率
		double assistEfficiency = 0;// 助攻效率
		try {
			String sql = "SELECT * FROM `teamsum" + season
					+ "` WHERE teamName='" + teamName + "'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				opponentFieldGoal = rs.getInt(1);
				opponentFieldGoalAttempts = rs.getInt(2);
				opponentTurnOver = rs.getInt(3);
				opponentFreeThrowAttempts = rs.getInt(4);
				oppenentScoring = rs.getInt(5);
				matches = rs.getInt(7);
				wins = rs.getInt(8);
				fieldGoal = rs.getInt(9);
				fieldGoalAttempts = rs.getInt(10);
				threePointFieldGoal = rs.getInt(11);
				threePointFieldGoalAttempts = rs.getInt(12);
				freeThrow = rs.getInt(13);
				freeThrowAttempts = rs.getInt(14);
				offensiveRebound = rs.getInt(15);
				defensiveRebound = rs.getInt(16);
				opponentOffensiveRebound = rs.getInt(17);
				opponentDefensiveRebound = rs.getInt(18);
				backboard = rs.getInt(19);
				assist = rs.getInt(20);
				steal = rs.getInt(21);
				block = rs.getInt(22);
				turnOver = rs.getInt(23);
				foul = rs.getInt(24);
				scoring = rs.getInt(25);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TeamPO po = new TeamPO(opponentFieldGoal, opponentFieldGoalAttempts,
				opponentTurnOver, opponentFreeThrowAttempts, oppenentScoring,
				teamName, matches, wins, fieldGoal, fieldGoalAttempts,
				threePointFieldGoal, threePointFieldGoalAttempts, freeThrow,
				freeThrowAttempts, offensiveRebound, defensiveRebound,
				opponentOffensiveRebound, opponentDefensiveRebound, backboard,
				assist, steal, block, turnOver, foul, scoring,
				fieldGoalPercentage, threePointShotPercentage,
				freeThrowPercentage, winningPercentage, possessions,
				offensiveEfficiency, defensiveEfficiency,
				offensivebackboardEfficiency, defensivebackboardEfficiency,
				stealEfficiency, assistEfficiency);
		return po;
	}

	public ArrayList<TeamPO> getAllTeamdata(String season, String key,
			String order) {
		String teamName = "";
		int opponentFieldGoal = 0;// 对手投篮命中数
		int opponentFieldGoalAttempts = 0;// 对手投篮出手次数
		int opponentTurnOver = 0;// 对手失误数
		int opponentFreeThrowAttempts = 0;// 对手罚球数
		int oppenentScoring = 0;// 对手得分
		int matches = 0;// 比赛场数
		int wins = 0;// 胜利场数
		int fieldGoal = 0;// 投篮命中数
		int fieldGoalAttempts = 0;// 投篮出手次数
		int threePointFieldGoal = 0;// 三分命中数
		int threePointFieldGoalAttempts = 0;// 三分出手数
		int freeThrow = 0;// 罚球命中数
		int freeThrowAttempts = 0;// 罚球出手数
		int offensiveRebound = 0;// 进攻篮板数
		int defensiveRebound = 0;// 防守篮板数
		int opponentOffensiveRebound = 0;// 对手进攻篮板数
		int opponentDefensiveRebound = 0;// 对手防守篮板数
		int backboard = 0;// 篮板数
		int assist = 0;// 助攻数
		int steal = 0;// 抢断数
		int block = 0;// 盖帽数
		int turnOver = 0;// 失误数
		int foul = 0;// 犯规数
		int scoring = 0;// 比赛得分
		double fieldGoalPercentage = 0;// 投篮命中率
		double threePointShotPercentage = 0;// 三分命中率
		double freeThrowPercentage = 0;// 三分命中率
		double winningPercentage = 0;// 胜率
		double possessions = 0;// 进攻回合
		double offensiveEfficiency = 0;// 进攻效率
		double defensiveEfficiency = 0;// 防守效率
		double offensivebackboardEfficiency = 0;// 进攻篮板效率
		double defensivebackboardEfficiency = 0;// 防守篮板效率
		double stealEfficiency = 0;// 抢断效率
		double assistEfficiency = 0;// 助攻效率
		ArrayList<TeamPO> po = new ArrayList<TeamPO>();
		try {
			String sql = "SELECT * FROM `teamsum" + season + "` ORDER BY "
					+ key + " " + order;
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				opponentFieldGoal = rs.getInt(1);
				opponentFieldGoalAttempts = rs.getInt(2);
				opponentTurnOver = rs.getInt(3);
				opponentFreeThrowAttempts = rs.getInt(4);
				oppenentScoring = rs.getInt(5);
				teamName = rs.getString(6);
				matches = rs.getInt(7);
				wins = rs.getInt(8);
				fieldGoal = rs.getInt(9);
				fieldGoalAttempts = rs.getInt(10);
				threePointFieldGoal = rs.getInt(11);
				threePointFieldGoalAttempts = rs.getInt(12);
				freeThrow = rs.getInt(13);
				freeThrowAttempts = rs.getInt(14);
				offensiveRebound = rs.getInt(15);
				defensiveRebound = rs.getInt(16);
				opponentOffensiveRebound = rs.getInt(17);
				opponentDefensiveRebound = rs.getInt(18);
				backboard = rs.getInt(19);
				assist = rs.getInt(20);
				steal = rs.getInt(21);
				block = rs.getInt(22);
				turnOver = rs.getInt(23);
				foul = rs.getInt(24);
				scoring = rs.getInt(25);
				TeamPO temp = new TeamPO(opponentFieldGoal,
						opponentFieldGoalAttempts, opponentTurnOver,
						opponentFreeThrowAttempts, oppenentScoring, teamName,
						matches, wins, fieldGoal, fieldGoalAttempts,
						threePointFieldGoal, threePointFieldGoalAttempts,
						freeThrow, freeThrowAttempts, offensiveRebound,
						defensiveRebound, opponentOffensiveRebound,
						opponentDefensiveRebound, backboard, assist, steal,
						block, turnOver, foul, scoring, fieldGoalPercentage,
						threePointShotPercentage, freeThrowPercentage,
						winningPercentage, possessions, offensiveEfficiency,
						defensiveEfficiency, offensivebackboardEfficiency,
						defensivebackboardEfficiency, stealEfficiency,
						assistEfficiency);
				po.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<TeamPO> getSomeTeamdata(String season, String condition,
			String key, String order) {
		String teamName = "";
		int opponentFieldGoal = 0;// 对手投篮命中数
		int opponentFieldGoalAttempts = 0;// 对手投篮出手次数
		int opponentTurnOver = 0;// 对手失误数
		int opponentFreeThrowAttempts = 0;// 对手罚球数
		int oppenentScoring = 0;// 对手得分
		int matches = 0;// 比赛场数
		int wins = 0;// 胜利场数
		int fieldGoal = 0;// 投篮命中数
		int fieldGoalAttempts = 0;// 投篮出手次数
		int threePointFieldGoal = 0;// 三分命中数
		int threePointFieldGoalAttempts = 0;// 三分出手数
		int freeThrow = 0;// 罚球命中数
		int freeThrowAttempts = 0;// 罚球出手数
		int offensiveRebound = 0;// 进攻篮板数
		int defensiveRebound = 0;// 防守篮板数
		int opponentOffensiveRebound = 0;// 对手进攻篮板数
		int opponentDefensiveRebound = 0;// 对手防守篮板数
		int backboard = 0;// 篮板数
		int assist = 0;// 助攻数
		int steal = 0;// 抢断数
		int block = 0;// 盖帽数
		int turnOver = 0;// 失误数
		int foul = 0;// 犯规数
		int scoring = 0;// 比赛得分
		double fieldGoalPercentage = 0;// 投篮命中率
		double threePointShotPercentage = 0;// 三分命中率
		double freeThrowPercentage = 0;// 三分命中率
		double winningPercentage = 0;// 胜率
		double possessions = 0;// 进攻回合
		double offensiveEfficiency = 0;// 进攻效率
		double defensiveEfficiency = 0;// 防守效率
		double offensivebackboardEfficiency = 0;// 进攻篮板效率
		double defensivebackboardEfficiency = 0;// 防守篮板效率
		double stealEfficiency = 0;// 抢断效率
		double assistEfficiency = 0;// 助攻效率
		ArrayList<TeamPO> po = new ArrayList<TeamPO>();
		String sql = "SELECT * FROM `teamsum" + season
				+ "` INNER JOIN(SELECT abbr FROM teaminfo WHERE " + condition
				+ ") AS a ON a.abbr=`teamsum" + season + "`.teamName ORDER BY "
				+ key + " " + order;
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				opponentFieldGoal = rs.getInt(1);
				opponentFieldGoalAttempts = rs.getInt(2);
				opponentTurnOver = rs.getInt(3);
				opponentFreeThrowAttempts = rs.getInt(4);
				oppenentScoring = rs.getInt(5);
				teamName = rs.getString(6);
				matches = rs.getInt(7);
				wins = rs.getInt(8);
				fieldGoal = rs.getInt(9);
				fieldGoalAttempts = rs.getInt(10);
				threePointFieldGoal = rs.getInt(11);
				threePointFieldGoalAttempts = rs.getInt(12);
				freeThrow = rs.getInt(13);
				freeThrowAttempts = rs.getInt(14);
				offensiveRebound = rs.getInt(15);
				defensiveRebound = rs.getInt(16);
				opponentOffensiveRebound = rs.getInt(17);
				opponentDefensiveRebound = rs.getInt(18);
				backboard = rs.getInt(19);
				assist = rs.getInt(20);
				steal = rs.getInt(21);
				block = rs.getInt(22);
				turnOver = rs.getInt(23);
				foul = rs.getInt(24);
				scoring = rs.getInt(25);
				TeamPO temp = new TeamPO(opponentFieldGoal,
						opponentFieldGoalAttempts, opponentTurnOver,
						opponentFreeThrowAttempts, oppenentScoring, teamName,
						matches, wins, fieldGoal, fieldGoalAttempts,
						threePointFieldGoal, threePointFieldGoalAttempts,
						freeThrow, freeThrowAttempts, offensiveRebound,
						defensiveRebound, opponentOffensiveRebound,
						opponentDefensiveRebound, backboard, assist, steal,
						block, turnOver, foul, scoring, fieldGoalPercentage,
						threePointShotPercentage, freeThrowPercentage,
						winningPercentage, possessions, offensiveEfficiency,
						defensiveEfficiency, offensivebackboardEfficiency,
						defensivebackboardEfficiency, stealEfficiency,
						assistEfficiency);
				po.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<TeamMatchPO> getTeamMonthMatch(String month, String team) {
		String[] temp = month.split("-");
		String season = "";
		if (temp[1].equals("01") || temp[1].equals("02") || temp[1].equals("03") || temp[1].equals("04")) {
			season = Integer.toString(Integer.parseInt(temp[0])-1) + "-" + temp[0];
		} else if (temp[1].equals("05") || temp[1].equals("06")) {
			season = Integer.toString(Integer.parseInt(temp[0])-1) + "-" + temp[0] + "a";
		} else {
			season = temp[0] + "-" + Integer.toString(Integer.parseInt(temp[0])+1);
		}
		ArrayList<TeamMatchPO> po = new ArrayList<TeamMatchPO>();
		String sql;
		if (temp[1].equals("04")) {
			sql = "SELECT * FROM `matches" + season + "a` WHERE date LIKE '" + month
					+ "%' AND name='" + team + "' ORDER BY date DESC";
			try {
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					TeamMatchPO tmp = new TeamMatchPO(rs.getString(1),
							rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getInt(6), rs.getInt(7),
							rs.getInt(8), rs.getInt(9), rs.getInt(10));
					po.add(tmp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sql = "SELECT * FROM `matches" + season + "` WHERE date LIKE '" + month
				+ "%' AND name='" + team + "' ORDER BY date DESC";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TeamMatchPO tmp = new TeamMatchPO(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
				po.add(tmp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public TeamMatchPO getTeamMatch(String date, String team) {
		String[] temp = date.split("-");
		String season = "";
		if (temp[1].equals("01") || temp[1].equals("02") || temp[1].equals("03") || temp[1].equals("04")) {
			season = Integer.toString(Integer.parseInt(temp[0])-1) + "-" + temp[0];
		} else if (temp[1].equals("05") || temp[1].equals("06")) {
			season = Integer.toString(Integer.parseInt(temp[0])-1) + "-" + temp[0] + "a";
		} else {
			season = temp[0] + "-" + Integer.toString(Integer.parseInt(temp[0])+1);
		}
		TeamMatchPO po = null;
		String sql = "SELECT * FROM `matches" + season + "` WHERE date= '" + date
				+ "' AND name='" + team + "'";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				po = new TeamMatchPO(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<TeamMatchPO> getTeamRecentFiveMatch(String season,String team) {
		ArrayList<TeamMatchPO> po = new ArrayList<TeamMatchPO>();
		String sql = "SELECT * FROM `matches" + season + "` WHERE name='" + team
				+ "' ORDER BY date DESC LIMIT 5";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				TeamMatchPO temp = new TeamMatchPO(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
				po.add(temp);
			}
			sql = "SELECT b.`date`,b.`host/guest`,b.`name`,b.`opponent`,b.`win/lose`,b.`total`,b.`first`,b.`second`,b.`third`,b.`fourth` FROM `matches" + season + "` a,`matches" + season + "` b WHERE a.opponent=b.name AND a.date=b.date AND a.name='"
					+ team + "' ORDER BY a.date DESC LIMIT 5";
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				TeamMatchPO temp = new TeamMatchPO(rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
				po.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<TeamMatchPO> getRecentFifteen() {
		ArrayList<TeamMatchPO> po = new ArrayList<TeamMatchPO>();
		String sql = "SELECT * FROM `matches14-15a` ORDER BY date DESC LIMIT 30";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				TeamMatchPO temp = new TeamMatchPO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
				po.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}
	
	public ArrayList<ArrayList<TeamPO>> getHostGuestdata(String season) {
		String teamName = "";
		int opponentFieldGoal = 0;// 对手投篮命中数
		int opponentFieldGoalAttempts = 0;// 对手投篮出手次数
		int opponentTurnOver = 0;// 对手失误数
		int opponentFreeThrowAttempts = 0;// 对手罚球数
		int oppenentScoring = 0;// 对手得分
		int matches = 0;// 比赛场数
		int wins = 0;// 胜利场数
		int fieldGoal = 0;// 投篮命中数
		int fieldGoalAttempts = 0;// 投篮出手次数
		int threePointFieldGoal = 0;// 三分命中数
		int threePointFieldGoalAttempts = 0;// 三分出手数
		int freeThrow = 0;// 罚球命中数
		int freeThrowAttempts = 0;// 罚球出手数
		int offensiveRebound = 0;// 进攻篮板数
		int defensiveRebound = 0;// 防守篮板数
		int opponentOffensiveRebound = 0;// 对手进攻篮板数
		int opponentDefensiveRebound = 0;// 对手防守篮板数
		int backboard = 0;// 篮板数
		int assist = 0;// 助攻数
		int steal = 0;// 抢断数
		int block = 0;// 盖帽数
		int turnOver = 0;// 失误数
		int foul = 0;// 犯规数
		int scoring = 0;// 比赛得分
		double fieldGoalPercentage = 0;// 投篮命中率
		double threePointShotPercentage = 0;// 三分命中率
		double freeThrowPercentage = 0;// 三分命中率
		double winningPercentage = 0;// 胜率
		double possessions = 0;// 进攻回合
		double offensiveEfficiency = 0;// 进攻效率
		double defensiveEfficiency = 0;// 防守效率
		double offensivebackboardEfficiency = 0;// 进攻篮板效率
		double defensivebackboardEfficiency = 0;// 防守篮板效率
		double stealEfficiency = 0;// 抢断效率
		double assistEfficiency = 0;// 助攻效率
		ArrayList<ArrayList<TeamPO>> r = new ArrayList<ArrayList<TeamPO>>();
		ArrayList<TeamPO> host = new ArrayList<TeamPO>();
		ArrayList<TeamPO> guest = new ArrayList<TeamPO>();
		String sql = "SELECT date,`host/guest`,name,opponent FROM `matches" + season + "` ORDER BY date DESC LIMIT 1200";
		try {
			ResultSet rs = statement.executeQuery(sql);
			ArrayList<ArrayList<String>> item = new ArrayList<ArrayList<String>>();
			while (rs.next()) {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				item.add(temp);
			}
			for (ArrayList<String> temp : item) {
				sql = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(threepointFieldGoal),SUM(threepointFieldGoalAttempts),SUM(freeThrow),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(backboard),SUM(assist),SUM(steal),SUM(block),SUM(turnOver),SUM(foul),SUM(scoring) FROM `playerdata" + season + "` WHERE date='" + temp.get(0) + "' AND team='" + temp.get(2) + "'";
				ResultSet tempRs = statement.executeQuery(sql);
				while(tempRs.next()) {
					fieldGoal = tempRs.getInt(1);
					fieldGoalAttempts = tempRs.getInt(2);
					threePointFieldGoal = tempRs.getInt(3);
					threePointFieldGoalAttempts = tempRs.getInt(4);
					freeThrow = tempRs.getInt(5);
					freeThrowAttempts = tempRs.getInt(6);
					offensiveRebound = tempRs.getInt(7);
					defensiveRebound = tempRs.getInt(8);
					backboard = tempRs.getInt(9);
					assist = tempRs.getInt(10);
					steal = tempRs.getInt(11);
					block = tempRs.getInt(12);
					turnOver = tempRs.getInt(13);
					foul = tempRs.getInt(14);
					scoring = tempRs.getInt(15);
				}
				sql = "SELECT SUM(fieldGoal),SUM(fieldGoalAttempts),SUM(freeThrowAttempts),SUM(offensiveRebound),SUM(defensiveRebound),SUM(turnOver),SUM(scoring) FROM `playerdata" + season + "` WHERE date='" + temp.get(0) + "' AND team='" + temp.get(3) + "'";
				tempRs = statement.executeQuery(sql);
				while(tempRs.next()) {
					opponentFieldGoal = tempRs.getInt(1);
					opponentFieldGoalAttempts = tempRs.getInt(2);
					opponentTurnOver = tempRs.getInt(6);
					opponentFreeThrowAttempts = tempRs.getInt(3);
					oppenentScoring = tempRs.getInt(7);
					opponentOffensiveRebound = tempRs.getInt(4);
					opponentDefensiveRebound = tempRs.getInt(5);
				}
				TeamPO po = new TeamPO(opponentFieldGoal, opponentFieldGoalAttempts, opponentTurnOver, opponentFreeThrowAttempts, oppenentScoring, teamName, matches, wins, fieldGoal, fieldGoalAttempts, threePointFieldGoal, threePointFieldGoalAttempts, freeThrow, freeThrowAttempts, offensiveRebound, defensiveRebound, opponentOffensiveRebound, opponentDefensiveRebound, backboard, assist, steal, block, turnOver, foul, scoring, fieldGoalPercentage, threePointShotPercentage, freeThrowPercentage, winningPercentage, possessions, offensiveEfficiency, defensiveEfficiency, offensivebackboardEfficiency, defensivebackboardEfficiency, stealEfficiency, assistEfficiency);
				if (temp.get(1).equals("h")) {
					host.add(po);
				} else {
					guest.add(po);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.add(host);
		r.add(guest);
		return r;
	}
	
}