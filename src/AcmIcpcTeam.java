import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 24/1/18
*/
public class AcmIcpcTeam {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numberOfTeamMembers = in.nextInt();
        int numberOfSkills = in.nextInt();
        String[] skillSet = new String[numberOfTeamMembers];
        for(int topic_i = 0; topic_i < numberOfTeamMembers; topic_i++){
            skillSet[topic_i] = in.next();
        }
        in.close();
        int maxSkills = 0;
        int maxSkillTeams = 0;
        int skillsOfATeam ;
        for(int i = 0; i<numberOfTeamMembers;i++){
            for(int j = i+1;j<numberOfTeamMembers;j++){
                skillsOfATeam = 0;
                //computing skills of a team
                for(int k = 0; k<numberOfSkills;k++){
                    if(skillSet[i].charAt(k) == '1' || skillSet[j].charAt(k) == '1'){
                        skillsOfATeam++;
                    }
                }
                //checking if its maxskills
                if(skillsOfATeam > maxSkills){
                    maxSkills = skillsOfATeam;
                    maxSkillTeams = 0;
                }
                if(skillsOfATeam == maxSkills){
                    maxSkillTeams++;
                }
            }
        }
        System.out.println(maxSkills + "\n" + maxSkillTeams);
    }
}
