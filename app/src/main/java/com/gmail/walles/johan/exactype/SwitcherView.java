/*
 * Copyright 2015 Johan Walles <johan.walles@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gmail.walles.johan.exactype;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 * View for switching between different keyboard layouts.
 * <p>
 * We suppress the view-constructor-used-by-tools warning since we don't expect this view to be used
 * by any tool. So far all our layout has been programmatic.
 * </p>
 */
@SuppressLint("ViewConstructor")
public class SwitcherView extends HorizontalScrollView {
    public SwitcherView(Context context, View currentView, View nextView) {
        super(context);

        // Default to showing currentView, have nextView on standby
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.addView(currentView);
        linearLayout.addView(nextView);
        addView(linearLayout);

        KeyboardTheme theme = new KeyboardTheme(context.getResources().getDisplayMetrics());
        theme.setIsFullKeyboard();

        // FIXME: Do we need to react to device orientation change and recalculate these?
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        int screenHeight = context.getResources().getDisplayMetrics().heightPixels;

        theme.setBounds(screenWidth, screenHeight);
        setLayoutParams(new ViewGroup.LayoutParams(theme.getWidth(), theme.getHeight()));
        Log.d("Johan", "SwitcherView sized to " + theme.getWidth() + "x" + theme.getHeight());
    }

    // FIXME: Intercept left swipe / fling and scroll accordingly

    // FIXME: Pass through non-intercepted actions if we're snapped to either side

    // FIXME: After scrolling, snap to either left or right depending on which is closest
}
