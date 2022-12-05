
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.DoubleWritable;

public class ValPerZipReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    @Override
    // Calculate the average valuation per year and zip
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        double length = 0;
        double total = 0L;
        for (DoubleWritable value : values) {
            total += value.get();
            length += 1;
        }
        if (length != 0) {
            double averageValuation = total / length;
            context.write(key, new DoubleWritable(averageValuation));
        }
    }
}
