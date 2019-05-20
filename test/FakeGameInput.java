public class FakeGameInput extends GameInput {
    /** Fake inputs to use in unit tests */

    private char answer = ' ';

    public void setAnswer(char answer) {
        this.answer = answer;
    }

    @Override
    public char askPlayer() {
        return answer;
    }
}
