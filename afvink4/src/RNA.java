public class RNA extends Sequentie {
        @Override
        public String getNtSeq() {
            return super.getNtSeq();
        }

        public RNA() {
            super();
        }

        @Override
        public void informatie() {
            super.informatie();
        }

        @Override
        public boolean checkSequentie(String ntSeq) {
            for (int i = 0, n = ntSeq.length(); i < n; i++){
                char c = ntSeq.charAt(i);
                String letter = Character.toString(c);
                if (!letter.matches("A|U|C|G")) {
                    return false;
                }
            }

            return true;
        }

        public RNA(String ntSeq) throws Exception { //constructor is altijd public en dan naam van classe
            super(ntSeq);
        }
    }
