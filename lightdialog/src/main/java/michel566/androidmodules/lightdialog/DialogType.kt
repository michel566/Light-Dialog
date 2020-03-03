package michel566.androidmodules.lightdialog

enum class DialogType {
    INFO, ALERT, ERROR;

    companion object {
        fun isDialogType(dialogType: String?): Boolean {
            return when (dialogType) {
                "INFO", "ALERT", "ERROR" -> true
                else -> false
            }
        }
    }
}