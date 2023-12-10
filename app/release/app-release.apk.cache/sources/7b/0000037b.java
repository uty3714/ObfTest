package b.a.a.a;

import androidx.recyclerview.widget.RecyclerView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class a {
    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String b(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.A());
        return sb.toString();
    }

    public static String c(String str, String str2) {
        return str + str2;
    }

    public static String d(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String e(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder f(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }
}