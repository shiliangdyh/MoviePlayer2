package com.i000phone.movieplayer2.utils;

import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/30.
 */
public class HttpTask <T extends Response> extends AsyncTask<String,Void,Response> {
    private Class<T> mClass;
    private Callback<T> callback;

    public HttpTask(Class<T> mClass, Callback<T> callback) {
        this.mClass = mClass;
        this.callback = callback;
    }

    @Override
    protected Response doInBackground(String... params) {

        try {
            Log.d("doInBackground","--------------");
            HttpURLConnection connection = (HttpURLConnection) new URL(params[0]).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() == 200) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                InputStream is = connection.getInputStream();
                byte[] b = new byte[100<<10];
                int len;
                while((len = is.read(b))!=-1){
                    bos.write(b,0,len);
                }
                Constructor<T> constructor = mClass.getConstructor(String.class);
                return constructor.newInstance(bos.toString());
            }else{
                return new ErrorResponse("ResponseCode:"+connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        } catch (InstantiationException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return new ErrorResponse(e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(Response response) {
        if (response instanceof ErrorResponse) {
            callback.doFailure(((ErrorResponse) response).getError());
        }else{
            callback.doResponse(((T) response));
        }
    }
    public interface Callback<T extends Response>{
        void doResponse(T t);
        void doFailure(String error);
    }
}
