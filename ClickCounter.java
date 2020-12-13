/*
 * Copyright 2020 KC Ochibili
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package Utils;


import android.os.Handler;
import java.util.Calendar;

/*
*
* This class listens for clicks, counts them and sends you the result trough a simple interface
*
* */

public class ClickCounter
{
    private ClickCountListener clickCountListener;

    int clicks;
    int clickSpace = 300; // span in milliseconds
    int lastClickToken;

    Calendar previousTime;

    public ClickCounter(){
        clicks = 0;
        lastClickToken = 0;
        previousTime = Calendar.getInstance();
    }



    public void setClickCountListener(ClickCountListener clickCountListener) {
        this.clickCountListener = clickCountListener;
    }



    public void addClick(){

        clicks++;
        lastClickToken++;
        waitAndSendClicks(lastClickToken);
    }


    private void waitAndSendClicks(final int token) {


        Runnable waitRunnable = new Runnable() {
            @Override
            public void run() {
                /* do what you need to do */

                if(token == lastClickToken){
                    sendClickCounts(clicks);
                    clicks = 0;

                }

            }
        };
        Handler handler = new Handler();
        handler.postDelayed(waitRunnable, (clickSpace + 100));


    }



    private void sendClickCounts(int clickCount){
        if(clickCountListener != null){
            clickCountListener.onClickingCompleted(clickCount);
        }
    }



    /**
     * Listener to get callback notifications for total number of clicks
     */
    public interface ClickCountListener {

        /**
         * Clicks has been wrapped and totaled
         */
        void onClickingCompleted(int clickCount);

    }



}
