/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package financas.domain.model;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Hilton
 */

public enum Classificacao {
    @NotNull
    RECEITA, DESPESA, CARTAO
}
