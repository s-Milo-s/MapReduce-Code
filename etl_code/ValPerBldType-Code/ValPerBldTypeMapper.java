import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ValPerBldTypeMapper extends Mapper<LongWritable, Text, Text, DoubleWritable> {
    // Value per building class and yeat
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] lineArr = line.split(",");
        Double l = Double.parseDouble(lineArr[2]);
        context.write(new Text(lineArr[4] + "," + lineArr[1]), new DoubleWritable(l));
    }
}
