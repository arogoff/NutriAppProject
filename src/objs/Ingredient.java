package src.objs;

public class Ingredient {
    public String[] ingredient = new String[53];
    public Ingredient(String[] ingredient){
        this.ingredient = ingredient;
    }

    public String getInfo(){
        String info = ingNum() + " - " + ingDesc();
        return info;
    }

    public String ingNum(){ return ingredient[0]; }
    public String ingDesc(){ return ingredient[1]; }
    public String water_g(){ return ingredient[2]; }
    public String energy_kcal(){ return ingredient[3]; }
    public String protein_g(){ return ingredient[4]; }
    public String lipid_tot_g(){ return ingredient[5]; }
    public String ash_g(){ return ingredient[6]; }
    public String carbohydrt_g(){ return ingredient[7]; }
    public String fiber_TD_g(){ return ingredient[8]; }
    public String sugar_Tot_g(){ return ingredient[9]; }
    public String calcium_mg(){ return ingredient[10]; }
    public String iron_mg(){ return ingredient[11]; }
    public String magnesium_mg(){ return ingredient[12]; }
    public String phosphorus_mg(){ return ingredient[13]; }
    public String potassium_mg(){ return ingredient[14]; }
    public String sodium_mg(){ return ingredient[15]; }
    public String zinc_mg(){ return ingredient[16]; }
    public String copper_mg(){ return ingredient[17]; }
    public String manganese_mg(){ return ingredient[18]; }
    public String selenium(){ return ingredient[19]; }
    public String vit_C_mg(){ return ingredient[20]; }
    public String thiamin_mg(){ return ingredient[21]; }
    public String riboflavin_mg(){ return ingredient[22]; }
    public String niacin_mg(){ return ingredient[23]; }
    public String panto_Acid_mg(){ return ingredient[24]; }
    public String vit_B6_mg(){ return ingredient[25]; }
    public String folate_Tot(){ return ingredient[26]; }
    public String folic_Acid(){ return ingredient[27]; }
    public String food_Folate(){ return ingredient[28]; }
    public String folate_DFE(){ return ingredient[29]; }
    public String choline_Tot_mg(){ return ingredient[30]; }
    public String vit_B12(){ return ingredient[31]; }
    public String vit_A_IU(){ return ingredient[32]; }
    public String vit_A_RAE(){ return ingredient[33]; }
    public String retinol(){ return ingredient[34]; }
    public String alpha_Carot(){ return ingredient[35]; }
    public String beta_Carot(){ return ingredient[36]; }
    public String beta_Crypt(){ return ingredient[37]; }
    public String lycopene(){ return ingredient[38]; }
    public String lut_Zea(){ return ingredient[39]; }
    public String vit_E_mg(){ return ingredient[40]; }
    public String vit_D(){ return ingredient[41]; }
    public String vit_D_IU(){ return ingredient[42]; }
    public String vit_K(){ return ingredient[43]; }
    public String fa_Sat_g(){ return ingredient[44]; }
    public String fa_Mono_g(){ return ingredient[45]; }
    public String fa_Poly_g(){ return ingredient[46]; }
    public String cholestrl_mg(){ return ingredient[47]; }
    public String gmWt1(){ return ingredient[48]; }
    public String gmWt1Desc(){ return ingredient[49]; }
    public String gmWt2(){ return ingredient[50]; }
    public String gmWt2Desc(){ return ingredient[51]; }
    public String refuse_Pct(){ return ingredient[52]; }

}
