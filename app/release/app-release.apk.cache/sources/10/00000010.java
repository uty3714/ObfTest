package a.b.c;

import a.b.g.a;
import a.b.h.c1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class h extends a.k.a.e implements i {
    public j n;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(n().d(context));
    }

    @Override // a.b.c.i
    public void b(a.b.g.a aVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        o();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // a.h.b.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        o();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // a.b.c.i
    public void f(a.b.g.a aVar) {
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) n().e(i);
    }

    @Override // a.b.c.i
    public a.b.g.a g(a.InterfaceC0004a interfaceC0004a) {
        return null;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return n().g();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        int i = c1.f132a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        n().j();
    }

    @Override // a.k.a.e
    public void m() {
        n().j();
    }

    public j n() {
        if (this.n == null) {
            a.e.c<WeakReference<j>> cVar = j.f16b;
            this.n = new k(this, null, this, this);
        }
        return this.n;
    }

    public a o() {
        return n().h();
    }

    @Override // a.k.a.e, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        n().k(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
    }

    @Override // a.k.a.e, androidx.activity.ComponentActivity, a.h.b.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        j n = n();
        n.i();
        n.l(bundle);
        super.onCreate(bundle);
    }

    @Override // a.k.a.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        n().m();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if ((Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // a.k.a.e, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent w;
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a o = o();
        if (menuItem.getItemId() != 16908332 || o == null || (((t) o).g.j() & 4) == 0 || (w = a.h.b.e.w(this)) == null) {
            return false;
        }
        if (shouldUpRecreateTask(w)) {
            ArrayList arrayList = new ArrayList();
            Intent p = p();
            if (p == null) {
                p = a.h.b.e.w(this);
            }
            if (p != null) {
                ComponentName component = p.getComponent();
                if (component == null) {
                    component = p.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                while (true) {
                    try {
                        Intent x = a.h.b.e.x(this, component);
                        if (x == null) {
                            break;
                        }
                        arrayList.add(size, x);
                        component = x.getComponent();
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                        throw new IllegalArgumentException(e);
                    }
                }
                arrayList.add(p);
            }
            r();
            if (!arrayList.isEmpty()) {
                Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
                intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
                Object obj = a.h.c.a.f332a;
                startActivities(intentArr, null);
                try {
                    int i2 = a.h.b.b.f321b;
                    finishAffinity();
                    return true;
                } catch (IllegalStateException unused) {
                    finish();
                    return true;
                }
            }
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        navigateUpTo(w);
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // a.k.a.e, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        n().n(bundle);
    }

    @Override // a.k.a.e, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        n().o();
    }

    @Override // a.k.a.e, androidx.activity.ComponentActivity, a.h.b.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        n().p(bundle);
    }

    @Override // a.k.a.e, android.app.Activity
    public void onStart() {
        super.onStart();
        n().q();
    }

    @Override // a.k.a.e, android.app.Activity
    public void onStop() {
        super.onStop();
        n().r();
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        n().y(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        o();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    public Intent p() {
        return a.h.b.e.w(this);
    }

    public void q() {
    }

    public void r() {
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        n().u(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        n().v(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        n().w(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        n().x(i);
    }
}