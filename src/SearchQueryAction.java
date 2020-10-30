import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.text.StringUtil;

public class SearchQueryAction extends AnAction {
    @Override
    public void update(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        boolean available = selectedText != null;

        Presentation presentation = e.getPresentation();
        presentation.setEnabled(available);
        presentation.setVisible(available);
    }

    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        CaretModel caretModel = editor.getCaretModel();
        String selectedText = caretModel.getCurrentCaret().getSelectedText();
        if (StringUtil.isNotEmpty(selectedText)) {
            BrowserUtil.browse("https://yandex.ru/search/?text=libgdx%20" + selectedText);
        }
    }
}