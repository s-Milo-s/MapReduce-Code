import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, LongWritable, Text> {
   public static boolean isNumeric(String str) {
     try {
         Double.parseDouble(str);
         return true;
     } catch(NumberFormatException e){
       return false;
    }
  } 
   @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineArr = line.split(",");
        if (lineArr.length == 40 && isNumeric(lineArr[12])&& !lineArr[29].equals("") && !lineArr[19].equals("") && !lineArr[6].equals("")) {
            // Collect market value for BBG#(0), Year(29), buildingVlaue (12), zip code(19), and building class (6)
            double buildingValue = Double.parseDouble(lineArr[12]);
	    if(buildingValue == 0){
		return; 
            }
	    if(buildingValue<20){
            	buildingValue = buildingValue*1000000;
            }	 
            String row = lineArr[0] + "," + lineArr[29]+","+String.valueOf(buildingValue)+ "," + lineArr[19] + "," + lineArr[6];
            context.write(key, new Text(row));
        }
	if(lineArr.length == 41 && isNumeric(lineArr[13]) && !lineArr[0].equals("") && !lineArr[30].equals("") && !lineArr[20].equals("") && !lineArr[7].equals("")){
	// Collect market value for BBG#(0), Year(30), buildingVlaue (13), zip code(20), and building class (7)
            double buildingValue = Double.parseDouble(lineArr[13]);
            if(buildingValue == 0){
                return;
            }
            if(buildingValue<20){
                buildingValue = buildingValue*1000000;
            }
            String row = lineArr[0] + "," + lineArr[30]+","+String.valueOf(buildingValue)+ "," + lineArr[20] + "," + lineArr[7];
            context.write(key, new Text(row));
	}
    }
}
