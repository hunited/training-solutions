package statemachine.typewriter;

public enum TypeWriterState {

    UPPERCASE {
        @Override
        TypeWriterState next() {
            return TypeWriterState.LOWERCASE;
        }
    },
    LOWERCASE {
        @Override
        TypeWriterState next() {
            return TypeWriterState.UPPERCASE;
        }
    };

    abstract TypeWriterState next();

}
