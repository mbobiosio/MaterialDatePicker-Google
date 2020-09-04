# MaterialDatePicker-Google

And YES, google finally brought a super useful component - MaterialDatePicker and it complies with material design.
The new component is super rich and can both be used as a DatePicker and a DateRangePicker.
This repository is designed to bring you the steps I used to effectively use the new awesome component.

## All the steps

1: Add the material component dependency in app-level build.gradle file


```bash
implementation 'com.google.android.material:material:1.3.0-alpha02'
```


2: Use a material component theme

```bash 
<style name="AppTheme" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <item name="colorPrimary">#2962FF</item>
        <item name="colorPrimaryVariant">#F4F4F4</item>
        <item name="colorOnPrimary">#FFFFFF</item>
        <item name="colorSecondary">#2962FF</item>
        <item name="colorSecondaryVariant">#0039CB</item>
        <item name="colorOnSecondary">#FFFFFF</item>
        <item name="colorError">#F44336</item>
        <item name="colorOnError">#FFFFFF</item>
        <item name="colorSurface">#FFFFFF</item>
        <item name="colorOnSurface">#212121</item>
        <item name="android:colorBackground">@color/colorBackground</item>
        <item name="colorOnBackground">#212121</item>
    </style>
    <color name="colorBackground">#F4F4F4</color>
```

This is what we hope to achieve.

<img src="https://raw.githubusercontent.com/mbobiosio/MaterialDatePicker-Google/master/device-2020-09-04-130158.png" width="250" height="444" />
<img src="https://raw.githubusercontent.com/mbobiosio/MaterialDatePicker-Google/master/device-2020-09-04-130236.png" width="250" height="444" />
<img src="https://raw.githubusercontent.com/mbobiosio/MaterialDatePicker-Google/master/device-2020-09-04-130302.png" width="250" height="444" />
<img src="https://raw.githubusercontent.com/mbobiosio/MaterialDatePicker-Google/master/device-2020-09-04-130529.png" width="250" height="444" />

## © License 
```
Copyright (c) 2020 Mbuodile Obiosio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
