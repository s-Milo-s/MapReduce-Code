import java.io.IOException;
import java.util.Arrays;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class StatsReducer extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        String[] years = new String[9];
        for (Text value : values) {
            String[] res = value.toString().split(",");
            if (res.length == 2) {
                int index = Integer.parseInt(res[0].replaceAll("\\s", "")) - 10;
                if (index < 9) {
                    years[index] = res[1].replaceAll("\\s", "");
                }
            }
        }
        Double total = 0.0;
        Double[] Change = new Double[8];
        for (int i = 1; i < years.length; i += 2) {
            total += ((Double.parseDouble(years[i]) / Double.parseDouble(years[i - 1])) - 1) * 100;
            Change[i - 1] = ((Double.parseDouble(years[i]) / Double.parseDouble(years[i - 1])) - 1) * 100;
        }
        for (int i = 0; i < Change.length; i++) {
            if (Change[i] == null) {
                Change[i] = 0.0;
            }
        }
        Arrays.sort(Change);
        total = total / years.length;
        context.write(key, new Text(Double.toString(total)));
        context.write(new Text("Median is:"), new Text(Double.toString(Change[4])));
    }
}
