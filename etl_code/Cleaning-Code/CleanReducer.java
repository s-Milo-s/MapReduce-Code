import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.LongWritable;

public class CleanReducer extends Reducer<LongWritable, Text, LongWritable, Text> {

    @Override
    public void reduce(LongWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String valueSum = "";
        for (Text value : values) {
            valueSum += value.toString();
        }
	if (!valueSum.equals("")) {
            context.write(key, new Text(valueSum));
        }
    }
}
