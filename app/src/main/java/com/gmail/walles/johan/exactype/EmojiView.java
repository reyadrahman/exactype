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

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class EmojiView extends View implements ExactypeMode.ModeChangeListener {
    private final KeyboardTheme theme;

    public EmojiView(Context context) {
        super(context);

        theme = new KeyboardTheme(context.getResources().getDisplayMetrics());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // FIXME: Draw emojis...
        canvas.drawColor(Color.RED);
    }

    @Override
    public void onModeChange(String[] rows, ExactypeMode.SwitchKey switchKey) {
        // This call intentionally ignored; we have only one mode
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldw, int oldh) {
        theme.setSize(width, height);
    }
}
