# Light-Dialog
Android component dialog with buttons for easy action implementations in it yours buttons


<h2>Why would i use this?</h2>

If you are tired of create a big codes and stay think in how to create yours popup messages, we have a solution for your project


<h2>Ok, i want test this</h2>

Right, the first step is add this lib a your dependency and configure your project:



<b>Step 1. Add it in your root build.gradle at the end of repositories:</b>

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
<b>Step 2. Add the dependency:</b>

	dependencies {
	        implementation 'com.github.michel566:Light-Dialog:0.11'
	}
  

In moment of write this, this release is 0.11.

And, yes. I copy this explaination of the Jitpack... :).


<b>Step 3. Add the object for the event of onClick:</b>

JAVA EXAMPLE:

        Button button = findViewById(R.id.button);	
	button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LightDialog(this, "Welcome!", DialogType.INFO).show();
            }
        });
	
	

KOTLIN EXAMPLE:

        button.setOnClickListener {
            LightDialog(this, "Welcome", DialogType.INFO).show()
        }



[![](https://jitpack.io/v/michel566/Light-Dialog.svg)](https://jitpack.io/#michel566/Light-Dialog)
