package com.example.csdc.myipcapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

public class MessengerService extends Service {

    class IncomingHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 0:
                    Toast.makeText(MessengerService.this, msg.arg1+"", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public MessengerService() {
    }

    Messenger mMessenger = new Messenger(new IncomingHandler());
    @Override
    public IBinder onBind(Intent intent) {
       /* // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");*/
        Toast.makeText(this, "binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }
}
