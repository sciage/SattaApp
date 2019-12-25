package in.co.sattamaster.ui.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.instacart.library.truetime.TrueTime;
import com.instacart.library.truetime.TrueTimeRx;

import java.io.IOException;

import in.co.sattamaster.data.DataManager;
import in.co.sattamaster.di.component.ApplicationComponent;
import in.co.sattamaster.di.component.DaggerApplicationComponent;
import in.co.sattamaster.di.module.ApplicationModule;
import in.co.sattamaster.di.rxbus.RxBus;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Harish on 7/20/2016.
 */
public class VoicemeApplication extends Application {
    private static Context context;
    // private WebService webService;
   // private static GoogleAnalytics sAnalytics;
 //   private static Tracker sTracker;
    protected RxBus bus;

    /*@Inject
    CalligraphyConfig mCalligraphyConfig;
    */



  /*  private class MainThreadBus extends RxBus {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        @Override
        public void post(final Object event){
            if (Looper.myLooper() == Looper.getMainLooper()){
                super.post(event);
            } else {
                mHandler.post(() -> {
                    MainThreadBus.super.post(event);
                });
            }
        }
    }
    */

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static VoicemeApplication get(Context context) {
        return (VoicemeApplication) context.getApplicationContext();
    }

   /* public VoicemeApplication() {
        getBus = new MainThreadBus();
    }
    */

    public static Context getContext() {
        return context;
    }

   // public static Auth getAuth() {
       // return auth;
   // }

   /* public static Bus getBus() {
        return getBus;
    }
    */

    public RxBus getBus() {
        if (bus == null) {
            bus = new RxBus();
        }

        return bus;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());
      //  auth = new Auth(this);
       // FacebookSdk.sdkInitialize(this);


      //  TrueTime.build().initialize();


        bus = new RxBus();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

        Fabric.with(this, new Crashlytics());




        //   AppLogger.init();


      /*  ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build()); */

     /*   if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
        */


      /*  try {
            webService = ServiceFactory.createRetrofitService(WebService.class);
        } catch (NullPointerException ex){
            Timber.e("Null Pointer exception");
        } catch (Exception ex){
            ex.printStackTrace();
        }
        */


      //  EmojiManager.install(new EmojiOneProvider());

        /* **************************************
        Timber.plant(new Timber.DebugTree() {
            // Add the line number to the TAG
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });

*/

      //  FacebookSdk.sdkInitialize(this);

   //     Fresco.initialize(this);

   //     sAnalytics = GoogleAnalytics.getInstance(this);
        /* *****************************************/
        //     Fabric.with(this, new Crashlytics());
      //   Timber.plant(new ReleaseTree());


        context = getApplicationContext();
        /*
         *Creates a periodic job to refresh token
         */

        //   LeakCanary.install(this);

      /*  Timber.d("Setting up StrictMode policy checking.");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());
                */

        final Fabric fabric = new Fabric.Builder(this)
                .kits( new Crashlytics())
                .debuggable(true)
                .build();

        /* final Fabric fabric = new Fabric.Builder(this)
                .kits(new Answers(), new Crashlytics(), new TwitterCore(authConfig), new Digits.Builder().build())
                .debuggable(true)
                .build(); */

        Fabric.with(fabric);

        // initDatabase();
    }






//    public WebService getWebService() {
    //    return webService;
  //  }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
       // MultiDex.install(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }

    /*
    private void initDatabase() {
        Realm.init(instance);
        RealmConfiguration realmConfiguration =
                new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
    */


}