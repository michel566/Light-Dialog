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

        Button btNoOptions = findViewById(R.id.bt_noOptions);
        final LightDialog infoDialog = new LightDialog(this, "This is a info dialog, with no option button", DialogType.INFO);
        btNoOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoDialog.show();
            }
        });
	

KOTLIN EXAMPLE:

        val infoDialog = LightDialog(this, "This is a info dialog, with no option button", DialogType.INFO)
        bt_noOptions.setOnClickListener {
            infoDialog.show()
        }

<h2>Customize your dialog</h2>

Lightdialog provides support for up to two buttons, to be able to insert them in your dialog, it is necessary to call the objects of the dialogs the following methods:


<b>One button</b>

JAVA EXAMPLE:

        alertDialog.onOptionConfirmClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
	            alertDialog.dismiss();
        	    Toast.makeText(MainActivity.this, "Confirm!", Toast.LENGTH_SHORT).show();
        	}
	}, "OK");

KOTLIN EXAMPLE:

	alertDialog.onOptionConfirmClickListener(
                {
                    alertDialog.dismiss()
                    Toast.makeText(this, "Confirm!", Toast.LENGTH_SHORT).show()
                }, "OK"
            )

<b>Two buttons</b>

JAVA EXAMPLE:

                errorDialog.onOptionConfirmClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        errorDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Confirm!", Toast.LENGTH_SHORT).show();

                    }
                }, "OK");

                errorDialog.onOptionEscapeClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        errorDialog.dismiss();
                        Toast.makeText(MainActivity.this, "Negate!", Toast.LENGTH_SHORT).show();
                    }
                }, "NO");

KOTLIN EXAMPLE:

	    errorDialog.onOptionConfirmClickListener(
                {
                    errorDialog.dismiss()
                    Toast.makeText(this, "Confirm!", Toast.LENGTH_SHORT).show()
                }, "OK"
            )

            errorDialog.onOptionEscapeClickListener(
                {
                    errorDialog.dismiss()
                    Toast.makeText(this, "Escape!", Toast.LENGTH_SHORT).show()
                }, "NO"
            )
        }


<h2>Dialog types</h2>

We use a default style in the dialog, a clean style to attendance to major cases, but we want in future releases, 
give you the opportunity to create your own layout, and insert it into our lib. But in any case, you are free to copy my project and adapt it to your greatest need, as long as it meets the requirements of the GNU.

We have a three default dialog types with three levels of criticality of this application, what you can call it through DialogType enum:

* DialogType.INFO (Light blue)
* DialogType.ALERT (Yellow)
* DialogType.ERROR (Red)


<h2>Extras</h2>

<b>isCanceledOnTouchOutside</b>

When you instantiate your dialog, you can set a last param of constructor with true and false, true is default, but false lock the current screen of context until the next event of dismiss to event click of your dialog button.

[![](https://jitpack.io/v/michel566/Light-Dialog.svg)](https://jitpack.io/#michel566/Light-Dialog)
