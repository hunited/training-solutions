package statemachine.seatheater;

public enum SeatHeaterState {

    ONE {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    TWO {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    THREE {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    },
    OFF {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    };

    abstract SeatHeaterState next();

}
