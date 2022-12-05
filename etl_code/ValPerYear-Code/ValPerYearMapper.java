import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.DoubleWritable;

public class ValPerYearMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    // For every year we see we add the valuation attached to it to the values of it
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineArr = line.split(",");
        double l = Double.parseDouble(lineArr[2]);
        context.write(new Text(lineArr[1].substring(0, 4)), new DoubleWritable(l));
    }
}
