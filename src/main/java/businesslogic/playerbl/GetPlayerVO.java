package businesslogic.playerbl;

import java.text.DecimalFormat;

import po.PlayerPO;
import po.PlayerinfoPO;
import vo.PlayerVO;

public class GetPlayerVO {
	DecimalFormat df1=new DecimalFormat("#.0");
	DecimalFormat df2=new DecimalFormat("#.00");
	DecimalFormat df3=new DecimalFormat("#.000");

	public PlayerVO getPlayerVO(PlayerPO playerPO){
		PlayerVO playerVO = new PlayerVO();
		if (playerPO.getAppearance()==0) {
			playerVO = new PlayerVO(
					playerPO.getPlayerName(),
					playerPO.getTeam(), 
					playerPO.getAppearance(),
					playerPO.getFirstPlay(),
					playerPO.getBackboard(),
					0,
					playerPO.getAssist(),
					0,
					Double.parseDouble(df1.format(playerPO.getMinutes())),
					0,
					playerPO.getFieldGoal(),
					0,
					playerPO.getFieldGoalAttempts(), 
					0,
					playerPO.getThreePointFieldGoal(),
					0,
					playerPO.getThreePointFieldGoalAttempts(),
					0,
					playerPO.getFreeThrow(),
					0,
					playerPO.getFreeThrowAttempts(), 
					0,
					playerPO.getOffensiveRebound(), 
					0,
					playerPO.getDefensiveRebound(),
					0,
					playerPO.getSteal(),
					0,
					playerPO.getBlock(),
					0,
					playerPO.getTurnOver(), 
					0,
					playerPO.getFoul(),
					0,
					playerPO.getScoring(),
					0,
					playerPO.getTeamFieldGoalAttempts(),
					playerPO.getTeamBackboard(),
					playerPO.getTeamFieldGoal(),
					playerPO.getTeamFreeThrow(),
					playerPO.getTeamOffensiveRebound(),
					playerPO.getTeamDefensiveRebound(),
					Double.parseDouble(df1.format(playerPO.getTeamMinutes())),
					playerPO.getTeamFreeThrowAttempts(),
					playerPO.getTeamTurnOver(),
					playerPO.getOpponentBackBoard(),
					playerPO.getOpponentOffensiveRebound(),
					playerPO.getOpponentDefensiveRebound(),
					playerPO.getOpponentFieldGoalAttempts(),
					playerPO.getOpponentThreePointFieldGoalAttempts(),
					Double.parseDouble(df3.format(playerPO.getFieldGoalShotPercentage())),
					Double.parseDouble(df3.format(playerPO.getThreePointShotPercentage())),
					Double.parseDouble(df3.format(playerPO.getFreeThrowPercentage())),
					Double.parseDouble(df1.format(playerPO.getEfficiency())),
					Double.parseDouble(df1.format(playerPO.getGmScEfficiency())),
					Double.parseDouble(df3.format(playerPO.getNearlyFivePercentage())),
					Double.parseDouble(df3.format(playerPO.getTrueShootingPercentage())),
					Double.parseDouble(df1.format(playerPO.getShootingEfficiency())),
					Double.parseDouble(df3.format(playerPO.getBackboardPercentage())),
					Double.parseDouble(df3.format(playerPO.getOffensiveReboundPercentage())),
					Double.parseDouble(df3.format(playerPO.getDefensiveReboundPercentage())),
					Double.parseDouble(df3.format(playerPO.getAssistPercentage())),
					Double.parseDouble(df3.format(playerPO.getStealPercentage())), 
					Double.parseDouble(df3.format(playerPO.getBlockPercentage())),
					Double.parseDouble(df3.format(playerPO.getTurnOverPercentage())), 
					Double.parseDouble(df1.format(playerPO.getUsage())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageScoring())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageScoring())),
					playerPO.getDoubleDouble(),
					Double.parseDouble(df3.format(playerPO.getNearlyFiveBackboardPercentage())),
					Double.parseDouble(df3.format(playerPO.getNearlyFiveAssistPercentage())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageBackboard())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageBackboard())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageAssist())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageAssist()))
					);
		}else {
			playerVO = new PlayerVO(
					playerPO.getPlayerName(),
					playerPO.getTeam(), 
					playerPO.getAppearance(),
					playerPO.getFirstPlay(),
					playerPO.getBackboard(),
					Double.parseDouble(df1.format(((double)playerPO.getBackboard())/playerPO.getAppearance())),
					playerPO.getAssist(),
					Double.parseDouble(df1.format(((double)playerPO.getAssist()/playerPO.getAppearance()))),
					Double.parseDouble(df1.format(playerPO.getMinutes())),
					Double.parseDouble(df1.format(((double)playerPO.getMinutes()/playerPO.getAppearance()))),
					playerPO.getFieldGoal(),
					Double.parseDouble(df1.format(((double)playerPO.getFieldGoal()/playerPO.getAppearance()))),
					playerPO.getFieldGoalAttempts(), 
					Double.parseDouble(df1.format(((double)playerPO.getFieldGoalAttempts()/playerPO.getAppearance()))),
					playerPO.getThreePointFieldGoal(),
					Double.parseDouble(df1.format(((double)playerPO.getThreePointFieldGoal()/playerPO.getAppearance()))),
					playerPO.getThreePointFieldGoalAttempts(),
					Double.parseDouble(df1.format(((double)playerPO.getThreePointFieldGoalAttempts()/playerPO.getAppearance()))),
					playerPO.getFreeThrow(),
					Double.parseDouble(df1.format(((double)playerPO.getFreeThrow()/playerPO.getAppearance()))),
					playerPO.getFreeThrowAttempts(), 
					Double.parseDouble(df1.format(((double)playerPO.getFreeThrowAttempts()/playerPO.getAppearance()))),
					playerPO.getOffensiveRebound(), 
					Double.parseDouble(df1.format(((double)playerPO.getOffensiveRebound()/playerPO.getAppearance()))),
					playerPO.getDefensiveRebound(),
					Double.parseDouble(df1.format(((double)playerPO.getDefensiveRebound()/playerPO.getAppearance()))),
					playerPO.getSteal(),
					Double.parseDouble(df1.format(((double)playerPO.getSteal()/playerPO.getAppearance()))),
					playerPO.getBlock(),
					Double.parseDouble(df1.format(((double)playerPO.getBlock()/playerPO.getAppearance()))),
					playerPO.getTurnOver(), 
					Double.parseDouble(df1.format(((double)playerPO.getTurnOver()/playerPO.getAppearance()))),
					playerPO.getFoul(),
					Double.parseDouble(df1.format(((double)playerPO.getFoul()/playerPO.getAppearance()))),
					playerPO.getScoring(),
					Double.parseDouble(df1.format(((double)playerPO.getScoring()/playerPO.getAppearance()))),
					playerPO.getTeamFieldGoalAttempts(),
					playerPO.getTeamBackboard(),
					playerPO.getTeamFieldGoal(),
					playerPO.getTeamFreeThrow(),
					playerPO.getTeamOffensiveRebound(),
					playerPO.getTeamDefensiveRebound(),
					Double.parseDouble(df1.format(playerPO.getTeamMinutes())),
					playerPO.getTeamFreeThrowAttempts(),
					playerPO.getTeamTurnOver(),
					playerPO.getOpponentBackBoard(),
					playerPO.getOpponentOffensiveRebound(),
					playerPO.getOpponentDefensiveRebound(),
					playerPO.getOpponentFieldGoalAttempts(),
					playerPO.getOpponentThreePointFieldGoalAttempts(),
					Double.parseDouble(df3.format(playerPO.getFieldGoalShotPercentage())),
					Double.parseDouble(df3.format(playerPO.getThreePointShotPercentage())),
					Double.parseDouble(df3.format(playerPO.getFreeThrowPercentage())),
					Double.parseDouble(df1.format(playerPO.getEfficiency())),
					Double.parseDouble(df1.format(playerPO.getGmScEfficiency())),
					Double.parseDouble(df3.format(playerPO.getNearlyFivePercentage())),
					Double.parseDouble(df3.format(playerPO.getTrueShootingPercentage())),
					Double.parseDouble(df1.format(playerPO.getShootingEfficiency())),
					Double.parseDouble(df3.format(playerPO.getBackboardPercentage())),
					Double.parseDouble(df3.format(playerPO.getOffensiveReboundPercentage())),
					Double.parseDouble(df3.format(playerPO.getDefensiveReboundPercentage())),
					Double.parseDouble(df3.format(playerPO.getAssistPercentage())),
					Double.parseDouble(df3.format(playerPO.getStealPercentage())), 
					Double.parseDouble(df3.format(playerPO.getBlockPercentage())),
					Double.parseDouble(df3.format(playerPO.getTurnOverPercentage())), 
					Double.parseDouble(df1.format(playerPO.getUsage())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageScoring())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageScoring())),
					playerPO.getDoubleDouble(),
					Double.parseDouble(df3.format(playerPO.getNearlyFiveBackboardPercentage())),
					Double.parseDouble(df3.format(playerPO.getNearlyFiveAssistPercentage())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageBackboard())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageBackboard())),
					Double.parseDouble(df1.format(playerPO.getPreviousAverageAssist())),
					Double.parseDouble(df1.format(playerPO.getNearlyFiveAverageAssist()))
					);
		}
		return playerVO;
	}

}
