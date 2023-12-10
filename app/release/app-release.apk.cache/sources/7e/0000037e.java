package b.b.a.a.a0;

import a.h.j.w.b;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import com.google.android.material.timepicker.ClockFaceView;
import top.niunaijun.blackobfuscator.asplugin.R;

/* loaded from: classes.dex */
public class b extends a.h.j.a {
    public final /* synthetic */ ClockFaceView d;

    public b(ClockFaceView clockFaceView) {
        this.d = clockFaceView;
    }

    @Override // a.h.j.a
    public void d(View view, a.h.j.w.b bVar) {
        this.f402b.onInitializeAccessibilityNodeInfo(view, bVar.f439b);
        int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
        if (intValue > 0) {
            TextView textView = this.d.B.get(intValue - 1);
            if (Build.VERSION.SDK_INT >= 22) {
                bVar.f439b.setTraversalAfter(textView);
            }
        }
        bVar.j(b.c.a(0, 1, intValue, 1, false, view.isSelected()));
    }
}