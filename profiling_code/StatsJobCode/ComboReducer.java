import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ComboReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        Double valueSum = 0.0;
        Double cnt = 0.0;
        for (Text value : values) {
            valueSum += Double.parseDouble(value.toString());
            cnt += 1;
        }
        if (cnt != 0) {
            valueSum = valueSum / cnt;
            String s = "," + String.valueOf(valueSum);
            context.write(key, new Text(s));
        }
    }
}

// every year with a average valuation