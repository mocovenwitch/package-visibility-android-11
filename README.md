# Experiment of Package Visibility on Android 11

## Purpose of this Experiment

I build several apps, and they share data between each other by using Content Provider in each app.

Recently, one of apps was upgraded to targeting `Android API Level 30`, and I found that `package visibility`
change in `Android 11` makes apps are invisible to each other in some situation.

This experiment is to find out the `simplest solution` making my apps `visible to each other`, regardless the installation
order, apps development targetSdkVersion, running Android OS version, or app signatures.


## The problem

`Giving:`
- app1 - targetSdkVersion 29
- app2 - targetSdkVersion 29
- app3 - targetSdkVersion 30
- running on device with Android 11 emulator

`Problem:`

Regardless the installation order, app1 and app2 are invisible to app3, until app3 access Content Provider
in app1 and 2.


![android11 visibility](arts/android11.png)

## Solution

[TODO]