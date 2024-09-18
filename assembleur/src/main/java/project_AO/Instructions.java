
package project_AO;



public class Instructions extends moto6809{
    
    tableau t = new tableau();
    String [][]tab = t.tableau ; 
    
    public void ABX() {
        // Ajouter l'accumulateur B à X
        
        String X = super.gettextx().getText();
        String Y = super.getjTextField14().getText();
        int x = Integer.parseInt(X,16);
        int y = Integer.parseInt(Y,16);
        int somme = x+y ;
        String k = Integer.toHexString(somme).toUpperCase();
        super.gettextx().setText(k);
        /*Graphics j = null ;
        this.update(j);
        this.revalidate();
        this.repaint();*/
        this.setVisible(true);
    }

    public void ADCA(String Y) {
    String X = super.getjTextField12().getText();
    int y = Integer.parseInt(Y,16);
    int x = Integer.parseInt(X,16);
    int somme = x + y;
    int zz = 0 , ww=0 ;
    if (somme > 15) 
    {
        zz=1 ; // Dépassement de 4 bits
    }
    if (somme > 255) {
        ww=1;  // Dépassement de 8 bits
    } 
    if(zz==1)
    {
        super.getFlags().setText("00100000"); 
    }
    else if (ww==1)
    {
        super.getFlags().setText("00000001"); 
    }
    else if (zz==1 && ww==1)
    {
        super.getFlags().setText("00100001"); 
    }
    else
    {
        super.getFlags().setText("00000000"); 
    }
    String k = Integer.toHexString(somme).toUpperCase();
    super.getjTextField12().setText(k);
    this.setVisible(true);
}


    public void ADCB(String Y) {
        // Addition du contenu mémoire à l'accumulateur B avec la retenue
        String X = super.getjTextField14().getText();
    int y = Integer.parseInt(Y,16);
    int x = Integer.parseInt(X,16);
    int somme = x + y;
    int zz = 0 , ww=0 ;
    if (somme > 15) 
    {
        zz=1 ; // Dépassement de 4 bits
    }
    if (somme > 255) {
        ww=1;  // Dépassement de 8 bits
    } 
    if(zz==1)
    {
        super.getFlags().setText("00100000"); 
    }
    else if (ww==1)
    {
        super.getFlags().setText("00000001"); 
    }
    else if (zz==1 && ww==1)
    {
        super.getFlags().setText("00100001"); 
    }
    else
    {
        super.getFlags().setText("00000000"); 
    }
    String k = Integer.toHexString(somme).toUpperCase();
    super.getjTextField14().setText(k);
    this.setVisible(true);
    }

    public void ADDA(String Y) {
        // Addition du contenu mémoire à l'accumulateur A
        String X = super.getjTextField12().getText();
        int y = Integer.parseInt(Y,16);
        int x = Integer.parseInt(X,16);
        int somme = x+y ;
        String k = Integer.toHexString(somme).toUpperCase();
        super.getjTextField12().setText(k);
        this.setVisible(true);
    }

    public void ADDB(String Y) {
        // Addition du contenu mémoire à l'accumulateur B
         String X = super.getjTextField14().getText();
        int y = Integer.parseInt(Y,16);
        int x = Integer.parseInt(X,16);
        int somme = x+y ;
        String k = Integer.toHexString(somme).toUpperCase();
        super.getjTextField14().setText(k);
        this.setVisible(true);
    }

    public void ADDD(String Y) {
        // Addition du contenu mémoire au registre D
         String X = super.getjTextField12().getText();
         String Z = super.getjTextField14().getText();
         String concat = X.concat(Z);
        int y = Integer.parseInt(Y,16);
        int x = Integer.parseInt(concat,16);
        int somme = x+y ;
        String k = Integer.toHexString(somme).toUpperCase();
        k = String.format("%04X", Integer.parseInt(k, 16));
        String A = k.substring(0, 2); 
        String B = k.substring(2, 4); 
        super.getjTextField12().setText(A);
        super.getjTextField14().setText(B);
        this.setVisible(true);
    }

    public void ANDA(String Y) {
        // ET logique entre A et le contenu mémoire
        String X = super.getjTextField12().getText();
        int y = Integer.parseInt(Y,16);
        int x = Integer.parseInt(X,16);
        int et_logique = x & y ;
        String k = Integer.toString(et_logique);
        super.getjTextField12().setText(k);
        this.setVisible(true);
        
    }

    public void ANDB(String Y) {
        // ET logique entre B et le contenu mémoire
        String X = super.getjTextField14().getText();
        int y = Integer.parseInt(Y,16);
        int x = Integer.parseInt(X,16);
        int et_logique = x & y ;
        String k = Integer.toString(et_logique);
        super.getjTextField14().setText(k);
        this.setVisible(true);
    }

    public void ANDCC() {
        // ET logique entre CC et le contenu mémoire
    }

    public void ASLA() {
        // Décalage arithmétique à gauche de A
        String X = super.getjTextField12().getText();
        int x = Integer.parseInt(X, 16);
        x <<= 1;  // decaler a gauche d'1 position
        x &= 0xFF;  // et logique bin x et 0ff / dik x kat3ni masquer dik lvaleur li ghatzad b decalage 
        X = Integer.toString(x, 16).toUpperCase();  // Convertit le résultat en hexadécimal
        super.getjTextField12().setText(X);
        this.setVisible(true);                //resultat ra s7e7 kaykhroj b hexa machi decimale ****
    }

    public void ASLB() {
        // Décalage arithmétique à gauche de B
        String X = super.getjTextField14().getText();
        int x = Integer.parseInt(X, 16);
        x <<= 1;  // decaler a gauche d'1 position
        x &= 0xFF;  // et logique bin x et 0ff / dik x kat3ni masquer dik lvaleur li ghatzad b decalage 
        X = Integer.toString(x, 16).toUpperCase();  // Convertit le résultat en hexadécimal
        super.getjTextField14().setText(X);
        this.setVisible(true);
}

    public void ASL(String x) {
        // Décalage arithmétique à gauche du contenu mémoire $0000
        int i,k ,  X;
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                            k= i ;
                            X =  Integer.parseInt(tab[k][1],16);
                            X <<= 1;  
                            X &= 0xFF;   
                            String decaler = Integer.toString(X, 16).toUpperCase(); 
                            tab[k][1]= decaler ;
                    }
        }
        this.setVisible(true);
    }

    public void ASRA() {
        // Décalage arithmétique à droite de A
        String X = super.getjTextField12().getText();
        int x = Integer.parseInt(X, 16);
        x >>= 1;  
        x &= 0xFF;  // chof asrb
        X = Integer.toString(x, 16).toUpperCase();  
        super.getjTextField12().setText(X);
        this.setVisible(true);
    }

    public void ASRB() {
        // Décalage arithmétique à droite de B
        String X = super.getjTextField14().getText();
        int x = Integer.parseInt(X, 16);
        x >>= 1;  // move to right
        x &= 0xFF;  // et logique bach yb9aw les 8bits dyal poids faible
        X = Integer.toString(x, 16).toUpperCase();  // conversion en Hexa
        super.getjTextField14().setText(X);
        this.setVisible(true);
    }

    public static void ASR() {
        // Décalage arithmétique à droite du contenu mémoire
    }

    public static void BCC() {
        // Branchement si pas de retenue / branchement si supérieur ou égal (non signé)
    }

    public static void BCS() {
        // Branchement si retenue / branchement si inférieur (non signé)
    }

    public void BEQ(String Y) {
        // Branchement si égal à zéro
        if(super.getFlags().getText().equalsIgnoreCase("00000100"))
        {
            
        }
    }

    public static void BGE() {
        // Branchement si supérieur ou égal
    }

    public static void BGT() {
        // Branchement si supérieur (signé)
    }

    public static void BHI() {
        // Branchement si supérieur (non signé)
    }

    public static void BHS() {
        // Branchement si supérieur ou égal (non signé)
    }

    public void BITA(String X) {
        // Test de bit mémoire avec A
        String A = super.getjTextField14().getText();
        int a = Integer.parseInt(A, 16);
        int x = Integer.parseInt(X, 16);
        int et_logique = a & x;
        int s = 0;
        String Z ;
        String N;

        if (et_logique == 0) {
            Z = "00000100";
            s += Integer.parseInt(Z, 2);
        }

        if ((a & 0x80) != 0) {
            N = "00001000";
            s += Integer.parseInt(N, 2);
        } else {
            N = "00000000";
            s += Integer.parseInt(N, 2);
        }

        String k = String.format("%8s", Integer.toBinaryString(s)).replace(' ', '0');
        super.getFlags().setText(k); //replace car il y a des espace quand on convertit
        this.setVisible(true);
        
    }

    public void BITB(String X) {
        // Test de bit mémoire avec B
         String A = super.getjTextField12().getText();
        int a = Integer.parseInt(A, 16);
        int x = Integer.parseInt(X, 16);
        int et_logique = a & x;
        int s = 0;
        String Z ;
        String N;

        if (et_logique == 0) {
            Z = "00000100";
            s += Integer.parseInt(Z, 2);
        }

        if ((a & 0x80) != 0) {
            N = "00001000";
            s += Integer.parseInt(N, 2);
        } else {
            N = "00000000";
            s += Integer.parseInt(N, 2);
        }

        String k = String.format("%8s", Integer.toBinaryString(s)).replace(' ', '0');
        super.getFlags().setText(k); //replace car il y a des espace quand on convertit
        this.setVisible(true);
    }

    public static void BLE() {
        // Branchement si inférieur ou égal (signé)
    }

    public static void BLO() {
        // Branchement si inférieur (non signé)
    }

    public static void BLS() {
        // Branchement si inférieur ou égal (non signé)
    }

    public static void BLT() {
        // Branchement si inférieur (signé)
    }

    public static void BMI() {
        // Branchement si négative
    }

    public static void BNE() {
        // Branchement si différent de zéro
    }

    public static void BPL() {
        // Branchement si positif
    }

    public static void BRA() {
        // Branchement inconditionnel
    }

    public static void BRN() {
        // Non branchement
    }

    public static void BSR() {
        // Branchement au sous-programme
    }

    public static void BVC() {
        // Branchement si pas de débordement
    }

    public static void BVS() {
        // Branchement si débordement
    }

    public static void CLR() {
        // Mise à zéro d'une case mémoire
    }

    public static void CMPA() {
        // Comparer A avec le contenu mémoire
    }

    public static void CMPB() {
        // Comparer B avec le contenu mémoire
    }

    public static void CMPD() {
        // Comparer D avec le contenu mémoire
    }

    public static void CMPS() {
        // Comparer S avec le contenu mémoire
    }

    public static void CMPU() {
        // Comparer U avec le contenu mémoire
    }
    public static void CMPX() {
        // Comparer X avec le contenu mémoire
    }

    public static void CMPY() {
        // Comparer Y avec le contenu mémoire
    }

    public static void COM() {
        // Complément à un du contenu mémoire
    }

    public static void CWAI() {
        // ET logique avec le registre CC puis attente d’interruption
    }

    public static void DAA() {
        // Ajustement décimal de A
    }

    public static void DEC() {
        // Décrémentation du contenu mémoire
    }

    public static void EORA() {
        // OU exclusif de A avec le contenu mémoire
    }

    public static void EORB() {
        // OU exclusif de B avec le contenu mémoire
    }

    public static void EXG() {
        // Échange de registres
    }

    public static void INC() {
        // Incrémentation du contenu mémoire
    }

    public static void JMP() {
        // Saut inconditionnel
    }

    public static void JSR() {
        // Saut au sous-programme
    }

    public void LDA(String S) {
        // Chargement de A avec le contenu mémoire
        int i ,k=0;
         String X ="0000";
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(S))
                    {
                         k= i ;
                        X = tab[k][1];
                        //continue outer;
                    }
        }
        
        
        super.getjTextField12().setText(X);
        this.getjTextField12().getParent().repaint();
        this.setVisible(true);
        super.refresh();
    }

    public void LDB(String S) {
        // Chargement de B avec le contenu mémoire
        int i ,k=0;
        String X="0000";
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(S))
                    {
                          k= i ;
                          X= tab[k][1];
                        //continue outer;
                    }
        }
        
        
        super.getjTextField14().setText(X);
        this.getjTextField14().getParent().repaint();
        this.setVisible(true);
        super.refresh();
    }

    public static void LDD() {
        // Chargement de D avec le contenu mémoire
    }

    public static void LDS() {
        // Chargement de S avec le contenu mémoire
    }

    public static void LDU() {
        // Chargement de U avec le contenu mémoire
    }

    public static void LDX() {
        // Chargement de X avec le contenu mémoire
    }

    public static void LDY() {
        // Chargement de Y avec le contenu mémoire
    }

    public static void LEAS() {
        // Chargement de l’adresse effective dans S
    }

    public static void LEAU() {
        // Chargement de l’adresse effective dans U
    }

    public static void LEAX() {
        // Chargement de l’adresse effective dans X
    }

    public static void LEAY() {
        // Chargement de l’adresse effective dans Y
    }

    public static void NEG() {
        // Complément à deux du contenu mémoire
    }

    public void NOP() {
        // Aucune opération
    }

    public static void ORA() {
        // OU logique entre A et le contenu mémoire
    }

    public static void ORB() {
        // OU logique entre B et le contenu mémoire
    }

    public static void ORCC() {
        // OU logique entre CC et le contenu mémoire
    }

    public static void PSHS() {
        // Empilement de registres sur S
    }

    public static void ROLA() {
        // Décalage circulaire à gauche de A
    }

    public static void ROLB() {
        // Décalage circulaire à gauche de B
    }

    public static void ROL() {
        // Décalage circulaire à gauche du contenu mémoire
    }

    public static void RORA() {
        // Décalage circulaire à droite de A
    }

    public static void RORB() {
        // Décalage circulaire à droite de B
    }

    public static void ROR() {
        // Décalage circulaire à droite du contenu mémoire
    }

    public static void RTI() {
        // Retour d’interruption
    }

    public static void RTS() {
        // Retour de sous-programme
    }

    public static void SBCA() {
        // Soustraction du contenu mémoire de A avec retenue
    }

    public static void SBCB() {
        // Soustraction du contenu mémoire de B avec retenue
    }

    public static void SEX() {
        // Extension de signe de l’accumulateur B à A
    }

    public void STA(String x) {
        // Stockage de A dans la cellule mémoire
        String y = getjTextField12().getText();
        int i ,k=0;
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=y;
                        //continue outer;
                    }
        }
        ROM.tableau[cpt][1] = "B7";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
       // this.getjTextField12().getParent().repaint();
     //  super.refresh();
                      setVisible(true);

    }
    

    
    public void STB(String x) {
        // Stockage de B dans la cellule mémoire
         String y = getjTextField14().getText();
        int i ,k=0;
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=y;
                        //continue outer;
                    }
        }        
        ROM.tableau[cpt][1] = "F7";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
                                  setVisible(true);

    }

    public void STD(String x) {
        // Stockage de D dans la cellule mémoire
        String a = getjTextField12().getText();
        String b = getjTextField14().getText();
        int i ,k=0;
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=a;
                          tab[k+1][1]=b;
                          
                    }
        }
                         setVisible(true);

    }

    public void STS(String x) {
        String y = gettexts().getText();
        int i ,k=0;
        String A1 = y.substring(0, 2); 
        String B2 = y.substring(2, 4); 
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=A1;
                          tab[k+1][1]=B2;
                        //continue outer;
                    }
        }        
        ROM.tableau[cpt][1] = "10";
                 cpt++;
        ROM.tableau[cpt][1] = "FF";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
                                  setVisible(true);

    }

    public void STU(String x) {
        // Stockage de U dans la cellule mémoire
         String y = gettextu().getText();
         String A1 = y.substring(0, 2); 
         String B2 = y.substring(2, 4); 
        int i ,k=0;
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=A1;
                          tab[k+1][1]=B2;
                        //continue outer;
                    }
        }        
        ROM.tableau[cpt][1] = "FF";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
                                  setVisible(true);

    }

    public void STX(String x) {
        // Stockage de X dans la cellule mémoire
        String y = gettextx().getText();
        int i ,k=0;
        String A1 = y.substring(0, 2); 
        String B2 = y.substring(2, 4); 
        for ( i=0 ; i < tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=A1;
                          tab[k+1][1]=B2;
                    }
        }        
        ROM.tableau[cpt][1] = "BF";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
                                  setVisible(true);

    }

    public void STY(String x) {
        // Stockage de Y dans la cellule mémoire
        String y = gettexty().getText();
        String A1 = y.substring(0, 2); 
        String B2 = y.substring(2, 4); 
        int i=0 , k=0 ;
        for (i=0 ; i< tab.length ; i++ )
        {
            if (tab[i][0].equalsIgnoreCase(x))
                    {
                          k= i ;
                          tab[k][1]=A1;
                          tab[k+1][1]=B2;
                    }
        }
        ROM.tableau[cpt][1] = "10";
                 cpt++;
        ROM.tableau[cpt][1] = "BF";
                 cpt++;
        String A = x.substring(0, 2); 
        ROM.tableau[cpt][1] = A;
                 cpt++;
        String B = x.substring(2, 4); 
        ROM.tableau[cpt][1] = B;
                 cpt++;
                 setVisible(true);
    }

    public static void SUBA() {
        // Soustraction du contenu mémoire de l’accumulateur A
    }

    public static void SUBB() {
        // Soustraction du contenu mémoire de l’accumulateur B
    }

    public static void SUBD() {
        // Soustraction du contenu mémoire de l’accumulateur D
    }

    public static void SWI() {
        // Interruption logicielle
    }

    public static void TFR() {
        // Transfert de registres
    }

    public static void TST() {
        // Test de la case mémoire
    }

}
