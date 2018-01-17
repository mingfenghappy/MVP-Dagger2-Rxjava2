package com.zenglb.framework.dagger;

import com.zenglb.framework.MyApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * 全局的单例的东西提到这里来，比如SharedPrefence,Daosession 等等 ！
 *
 * Created by anylife.zlb@gmail.com on 2018/1/11.
 */
@Singleton
@Component(modules = {
        MainModule.class,              //全局的Module,要确保提供的对象是全局唯一的
        AllActivityModule.class,       //减少模版代码,需要依赖注入的只需要添加两行代码就好了
        AndroidInjectionModule.class,  //在应用程序的MainComponent（applocation 中inject了）中，注入AndroidInjectionModule，
        // 以确保Android的类(Activity、Fragment、Service、BroadcastReceiver及ContentProvider等)可以绑定。
        // 一般把AndroidInjectionModule放在ApplicationComponent中，其他的Component依赖Application即可

        AndroidSupportInjectionModule.class,  //使用的Fragment 是V4 包中的？不然就只需要AndroidInjectionModule

})

// DaggerMainComponent.create().inject(this);   //在MyApplication 中 XXX.inject(this) 了已经
// 带有构造方法并且参数被使用的情况下所产生的Component 是没有Create方法的
public interface MainComponent {

    void inject(MyApplication application);

}