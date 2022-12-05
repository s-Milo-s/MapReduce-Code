import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class ValPerZipMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    // Value perzip and year
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineArr = line.split(",");
        double l = Double.parseDouble(lineArr[2]);
        context.write(new Text(lineArr[3] + "," + lineArr[1]), new DoubleWritable(l));
    }
}
