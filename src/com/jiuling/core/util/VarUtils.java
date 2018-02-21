package com.jiuling.core.util;

import com.loocme.plugin.spring.comp.SqlExecutor;
import com.loocme.sys.datastruct.Var;
import com.loocme.sys.datastruct.WeekArray;

public class VarUtils {
	public static void main(String[] args) {
		
	}
	
	@SuppressWarnings("unused")
	public void addDataByJson(String jsonStr){
		String path = VarUtils.class.getClassLoader().getResource("output.json").getPath(); 
		String s = JSONUtil.readJsonFile(path);
		Var var = Var.fromJson(s);
		String date = var.getString("date");
		String comments = var.getString("comments");
		String localFilePath = var.getString("file");
		String original_size = var.getString("original_size");
		String output_size = var.getString("output_size");
		SqlExecutor executor = SqlExecutor.getInstance();
		//WeekArray vehicles = var.getArray("objects.vehicle");
		//addVehicle(vehicles,executor);
		WeekArray personBikes = var.getArray("objects.personbike");
		addBike(personBikes,executor);
		executor.commit();
	}
	
	public void addPerson(WeekArray persons,SqlExecutor executor){
		
	}
	
	@SuppressWarnings("unused")
	public void addBike(WeekArray personBikes,SqlExecutor executor){
		for(int j=0;j<personBikes.getSize();j++){
			Var personbike = personBikes.get(j+"");
			String personbikeid = personbike.getString("id");
			int start_frmidx = personbike.getInt("start_frmidx");
			int end_frmidx = personbike.getInt("end_frmidx");
			WeekArray personBikesfrminfo = personbike.getArray("frminfo");
			for(int j1=0;j1<personBikesfrminfo.getSize();j1++){
				Var frminfo = personBikesfrminfo.get(j1+"");
				int frmidx = frminfo.getInt("frmidx");
				String file = frminfo.getString("file");
				int posX = frminfo.getInt("pos.x");
				int posY = frminfo.getInt("pos.y");
				int posW = frminfo.getInt("pos.w");
				int posH = frminfo.getInt("pos.h");
				String pos = posX+","+posY+","+posW+","+posH;
				int enlargePosX = frminfo.getInt("enlargePos.x");
				int enlargePosY = frminfo.getInt("enlargePos.y");
				int enlargePosW = frminfo.getInt("enlargePos.w");
				int enlargePosH = frminfo.getInt("enlargePos.h");
				String enlargePos = enlargePosX+","+enlargePosY+","+enlargePosW+","+enlargePosH;

				String gender = frminfo.getString("attribute.gender");
				String age = frminfo.getString("attribute.age");
				String angle = frminfo.getString("attribute.angle");
				String glasses = frminfo.getString("attribute.glasses");
				String backpack = frminfo.getString("attribute.backpack");
				String umbrella = frminfo.getString("attribute.umbrella");
				String carryingbag = frminfo.getString("attribute.carryingbag");
				String billboard = frminfo.getString("attribute.billboard");
				String plate = frminfo.getString("attribute.plate");
				String uppercolor = frminfo.getString("attribute.uppercolor");
				String helmetcolor = frminfo.getString("attribute.helmetcolor");
				String upperclothing = frminfo.getString("attribute.upperclothing");
				
				int umbrellaX = frminfo.getInt("umbrella.x");
				int umbrellaY = frminfo.getInt("umbrella.y");
				int umbrellaW = frminfo.getInt("umbrella.w");
				int umbrellaH = frminfo.getInt("umbrella.h");
				String umbrellaPos = umbrellaX+","+umbrellaY+","+umbrellaW+","+umbrellaH;
				int bikebillboardX = frminfo.getInt("bikebillboard.x");
				int bikebillboardY = frminfo.getInt("bikebillboard.y");
				int bikebillboardW = frminfo.getInt("bikebillboard.w");
				int bikebillboardH = frminfo.getInt("bikebillboard.h");
				String bikebillboardPos = bikebillboardX+","+bikebillboardY+","+bikebillboardW+","+bikebillboardH;
				int upperbodyX = frminfo.getInt("upperbody.x");
				int upperbodyY = frminfo.getInt("upperbody.y");
				int upperbodyW = frminfo.getInt("upperbody.w");
				int upperbodyH = frminfo.getInt("upperbody.h");
				String upperbodyPos = upperbodyX+","+upperbodyY+","+upperbodyW+","+upperbodyH;
				
				int headX = frminfo.getInt("head.x");
				int headY = frminfo.getInt("head.y");
				int headW = frminfo.getInt("head.w");
				int headH = frminfo.getInt("head.h");
				String headPos = headX+","+headY+","+headW+","+headH;
				System.out.println(frmidx+","+file+","+posX);
				  
				StringBuffer sb = new StringBuffer();
                sb.append(" insert into bike_result(");
                sb.append(" imgurl,pos,head_pos,upperbody_pos,enlargePos,sex,age,billboard,bag");
                sb.append(" billboard_pos,bike_has_plate,coat_style,");
                sb.append(" glasses,umbrella,angle,handbag,startframeidx,endframeidx,uppercolor,helmetcolor,umbrella_pos)");
                sb.append(" values (");
                sb.append("?,?,?,?,?,?,?,?,?,");
                sb.append("?,?,?,");
                sb.append("?,?,?,?,?,?,?,?,?)");
                executor.addSql(sb.toString(),
	                file,pos,headPos,upperbodyPos,enlargePos,gender,age,billboard,backpack,
	                bikebillboardPos,plate,upperclothing,
	                glasses,umbrella,angle,carryingbag,start_frmidx,end_frmidx,uppercolor,helmetcolor,umbrellaPos
                );
			}
		}
	}
	
	@SuppressWarnings("unused")
	public void addVehicle(WeekArray vehicles,SqlExecutor executor){
		for(int i=0;i<vehicles.getSize();i++){
			Var vehicle = vehicles.get(i+"");
			String vechileId = vehicle.getString("id");
			//System.out.println(vechileId);
		}
	}
}
