package taytom258.core.util.db;

import java.util.ArrayList;

public class CircuitStatus{
	
	public static void circuitStatusRepair(){
		Database.init(false);
		String circuitStatus = "";
		
		String query = "SELECT FullCCSD, Ignore, TSONumber, Installed FROM TSO";
		ArrayList<String> al = Database.dbQuery(query);
		if(al.size()>0){
			for(int i=1;i<al.size();i+=4){
//				System.out.println(al.get(i-1)+" : "+al.get(i));
				if(Integer.parseInt(al.get(i)) == 0){
					String[] sa = al.get(i+1).split("-");
					if(sa[1].equals("01")){
						circuitStatus = "Inactive";
						if(Integer.parseInt(al.get(i+2)) != 0){
							circuitStatus = "Active";
						}
					}else if(sa[1].equals("01Z")){
						circuitStatus = "Cancelled";
					}else if(sa[1].equals("99")){
						circuitStatus = "Pending Disco";
						if(Integer.parseInt(al.get(i+2)) != 0){
							circuitStatus = "Discontinued";
						}
					}else if(sa[1].equals("99Z")){
						circuitStatus = "Active";
					}else{
						circuitStatus = "Pending Change";
						if(Integer.parseInt(al.get(i+2)) != 0){
							circuitStatus = "Active";
						}
					}
					String update = "UPDATE Circuits SET CircuitStatus = '"+circuitStatus+"' WHERE FullCCSD = '"+al.get(i-1)+"'";
					Database.dbUpdate(update);
//					dbUpdate("Circuits", "CircuitStatus", circuitStatus, al.get(i-1), "FullCCSD");
				}
			}
		}
		Database.init(true);
	}
	
	public static void circuitStatusUpdateTSO(String fullccsd){
		Database.init(false);
		String circuitStatus = "";
		
		String query = "SELECT FullCCSD, Ignore, TSONumber FROM TSO WHERE FullCCSD = '"+fullccsd+"'";
		ArrayList<String> al = Database.dbQuery(query);
		if(al.size()>0){
			for(int i=1;i<al.size();i+=3){
//				System.out.println(al.get(i-1)+" : "+al.get(i));
				if(Integer.parseInt(al.get(i)) == 0){
					String[] sa = al.get(i+1).split("-");
					if(sa[1].equals("01")){
						circuitStatus = "Inactive";
					}else if(sa[1].equals("01Z")){
						circuitStatus = "Cancelled";
					}else if(sa[1].equals("99")){
						circuitStatus = "Pending Disco";
					}else if(sa[1].equals("99Z")){
						circuitStatus = "Active";
					}else{
						circuitStatus = "Pending Change";
					}
					String update = "UPDATE Circuits SET CircuitStatus = '"+circuitStatus+"' WHERE FullCCSD = '"+al.get(i-1)+"'";
					Database.dbUpdate(update);
//					dbUpdate("Circuits", "CircuitStatus", circuitStatus, al.get(i-1), "FullCCSD");
				}
			}
		}
		Database.init(true);
	}
	
	public static void circuitStatusUpdateIER(String TSONum){
		Database.init(false);
		String circuitStatus = "";
		
		String query = "SELECT FullCCSD, Ignore, Installed FROM TSO WHERE TSONumber = '"+TSONum+"'";
		ArrayList<String> al = Database.dbQuery(query);
		if(al.size()>0){
			for(int i=0;i<al.size();i+=3){
				if(Integer.parseInt(al.get(i)) == 0){
					String[] sa = TSONum.split("-");
					if(sa[1].equals("01")){
						circuitStatus = "Active";
					}else if(sa[1].equals("99")){
						circuitStatus = "Discontinued";
					}else if(sa[1].equals("99Z")){
						circuitStatus = "Active";
					}else{
						circuitStatus = "Active";
					}
				}
				String update = "UPDATE Circuits SET CircuitStatus = '"+circuitStatus+"' WHERE FullCCSD = '"+al.get(i)+"'";
				Database.dbUpdate(update);
				update = "UPDATE TSO SET Installed = '"+-1+"' WHERE TSONumber = '"+TSONum+"'";
				Database.dbUpdate(update);
			}
		}
		Database.init(true);
	}
}
