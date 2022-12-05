import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class ZipVBuildingTypeMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    // Value perzip and bld type and year
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineArr = line.split(",");
        double l = Double.parseDouble(lineArr[2]);
        // year , zip, bld type
        context.write(new Text(lineArr[1] + "," + lineArr[3] + "," + lineArr[4]+"," ), new DoubleWritable(l));
    }
}
