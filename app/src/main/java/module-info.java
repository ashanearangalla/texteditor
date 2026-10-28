module edu.curtin.texteditor
{
    requires transitive javafx.controls;
    requires org.antlr.antlr4.runtime;
    requires edu.curtin.api;
    requires org.apache.groovy;

    exports edu.curtin.texteditor to javafx.graphics;
}
