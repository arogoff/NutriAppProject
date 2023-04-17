package src.objs;

public class Ingredient extends Food{
    public String[] ingredient;
    public Ingredient(String[] ingredient){
        super(ingredient[1], Double.parseDouble(ingredient[3]), Double.parseDouble(ingredient[44]) + Double.parseDouble(ingredient[45]) + Double.parseDouble(ingredient[46]), Double.parseDouble(ingredient[4]), Double.parseDouble(ingredient[8]), Double.parseDouble(ingredient[7]));
        this.ingredient = ingredient;
    }

    public String getInfo(){
        String info = ingNum() + " - " + ingDesc();
        return info;
    }

    public double ingNum(){ return Double.parseDouble(ingredient[0]); }
    public String ingDesc(){ return ingredient[1]; }
    public double water_g(){ return Double.parseDouble(ingredient[2]); }
    public double energy_kcal(){ return Double.parseDouble(ingredient[3]); }
    public double protein_g(){ return Double.parseDouble(ingredient[4]); }
    public double lipid_tot_g(){ return Double.parseDouble(ingredient[5]); }
    public double ash_g(){ return Double.parseDouble(ingredient[6]); }
    public double carbohydrt_g(){ return Double.parseDouble(ingredient[7]); }
    public double fiber_TD_g(){ return Double.parseDouble(ingredient[8]); }
    public double sugar_Tot_g(){ return Double.parseDouble(ingredient[9]); }
    public double calcium_mg(){ return Double.parseDouble(ingredient[10]); }
    public double iron_mg(){ return Double.parseDouble(ingredient[11]); }
    public double magnesium_mg(){ return Double.parseDouble(ingredient[12]); }
    public double phosphorus_mg(){ return Double.parseDouble(ingredient[13]); }
    public double potassium_mg(){ return Double.parseDouble(ingredient[14]); }
    public double sodium_mg(){ return Double.parseDouble(ingredient[15]); }
    public double zinc_mg(){ return Double.parseDouble(ingredient[16]); }
    public double copper_mg(){ return Double.parseDouble(ingredient[17]); }
    public double manganese_mg(){ return Double.parseDouble(ingredient[18]); }
    public double selenium(){ return Double.parseDouble(ingredient[19]); }
    public double vit_C_mg(){ return Double.parseDouble(ingredient[20]); }
    public double thiamin_mg(){ return Double.parseDouble(ingredient[21]); }
    public double riboflavin_mg(){ return Double.parseDouble(ingredient[22]); }
    public double niacin_mg(){ return Double.parseDouble(ingredient[23]); }
    public double panto_Acid_mg(){ return Double.parseDouble(ingredient[24]); }
    public double vit_B6_mg(){ return Double.parseDouble(ingredient[25]); }
    public double folate_Tot(){ return Double.parseDouble(ingredient[26]); }
    public double folic_Acid(){ return Double.parseDouble(ingredient[27]); }
    public double food_Folate(){ return Double.parseDouble(ingredient[28]); }
    public double folate_DFE(){ return Double.parseDouble(ingredient[29]); }
    public double choline_Tot_mg(){ return Double.parseDouble(ingredient[30]); }
    public double vit_B12(){ return Double.parseDouble(ingredient[31]); }
    public double vit_A_IU(){ return Double.parseDouble(ingredient[32]); }
    public double vit_A_RAE(){ return Double.parseDouble(ingredient[33]); }
    public double retinol(){ return Double.parseDouble(ingredient[34]); }
    public double alpha_Carot(){ return Double.parseDouble(ingredient[35]); }
    public double beta_Carot(){ return Double.parseDouble(ingredient[36]); }
    public double beta_Crypt(){ return Double.parseDouble(ingredient[37]); }
    public double lycopene(){ return Double.parseDouble(ingredient[38]); }
    public double lut_Zea(){ return Double.parseDouble(ingredient[39]); }
    public double vit_E_mg(){ return Double.parseDouble(ingredient[40]); }
    public double vit_D(){ return Double.parseDouble(ingredient[41]); }
    public double vit_D_IU(){ return Double.parseDouble(ingredient[42]); }
    public double vit_K(){ return Double.parseDouble(ingredient[43]); }
    public double fa_Sat_g(){ return Double.parseDouble(ingredient[44]); }
    public double fa_Mono_g(){ return Double.parseDouble(ingredient[45]); }
    public double fa_Poly_g(){ return Double.parseDouble(ingredient[46]); }
    public double cholestrl_mg(){ return Double.parseDouble(ingredient[47]); }
    public double gmWt1(){ return Double.parseDouble(ingredient[48]); }
    public String gmWt1Desc(){ return ingredient[49]; }
    public double gmWt2(){ return Double.parseDouble(ingredient[50]); }
    public String gmWt2Desc(){ return ingredient[51]; }
    public double refuse_Pct(){ return Double.parseDouble(ingredient[52]); }

    @Override
    public void createFood() {

    }
}
