import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.DoubleWritable;

public class ValPerYearReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable> {
    @Override
    // Calculate the average valuation per year across all buroughs
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {
        int length = 0;
        double total = 0.0;
        for (DoubleWritable value : values) {
            total += value.get();
            length += 1;
        }
        double averageValuation = total / length;
        context.write(key, new DoubleWritable(averageValuation));
    }
}
