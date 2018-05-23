/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joguinhodavelha;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author hugosilva
 */
public class Tela extends javax.swing.JFrame {

    private String[] t;
    private int turno;

    public Tela() {
        this.getContentPane().setBackground(Color.BLACK);
        this.t = new String[]{"", "", "", "", "", "", "", "", ""};
        this.turno = 0;
        initComponents();
    }

    private void jogadaJogador(int posicao, JButton botao) {
        if (botao.getIcon() != null) {
            return;
        }
        botao.setIcon(new ImageIcon(getClass().getResource("X.png")));
        t[posicao - 1] = "X";
        turno++;
        this.jogadaMaquina();
    }

    private void marcarMaquina(int posicao) {
        JButton botao;
        switch (posicao) {
            case 0:
                botao = this.jButton1;
                break;
            case 1:
                botao = this.jButton2;
                break;
            case 2:
                botao = this.jButton3;
                break;
            case 3:
                botao = this.jButton4;
                break;
            case 4:
                botao = this.jButton5;
                break;
            case 5:
                botao = this.jButton6;
                break;
            case 6:
                botao = this.jButton7;
                break;
            case 7:
                botao = this.jButton8;
                break;
            default:
                botao = this.jButton9;
                break;
        }
        botao.setIcon(new ImageIcon(getClass().getResource("O.png")));
        t[posicao] = "O";
    }

    private void jogadaMaquina() {
        switch (turno) {
            case 1:
                if (t[4].equals("")) {
                    this.marcarMaquina(4);
                } else {
                    this.marcarMaquina(0);
                }
                break;
            case 2:
                // Defesa
                if (t[0].equals("X")) {
                    if (t[1].equals("X")) {
                        this.marcarMaquina(2);
                        return;
                    } else if (t[2].equals("X")) {
                        this.marcarMaquina(1);
                        return;
                    } else if (t[3].equals("X")) {
                        this.marcarMaquina(6);
                        return;
                    } else if (t[6].equals("X")) {
                        this.marcarMaquina(3);
                        return;
                    }
                } else if (t[1].equals("X")) {
                    if (t[2].equals("X")) {
                        this.marcarMaquina(0);
                        return;
                    } else if (t[4].equals("X")) {
                        this.marcarMaquina(7);
                        return;
                    } else if (t[7].equals("X")) {
                        this.marcarMaquina(4);
                        return;
                    }
                } else if (t[2].equals("X")) {
                    if (t[4].equals("X")) {
                        this.marcarMaquina(6);
                        return;
                    } else if (t[5].equals("X")) {
                        this.marcarMaquina(8);
                        return;
                    } else if (t[6].equals("X")) {
                        if (t[4].equals("")) {
                            this.marcarMaquina(4);
                            return;
                        }
                    } else if (t[8].equals("X")) {
                        this.marcarMaquina(5);
                        return;
                    }
                } else if (t[3].equals("X")) {
                    if (t[4].equals("X")) {
                        this.marcarMaquina(5);
                        return;
                    } else if (t[6].equals("X")) {
                        this.marcarMaquina(0);
                        return;
                    }
                } else if (t[4].equals("X")) {
                    if (t[5].equals("X")) {
                        this.marcarMaquina(3);
                        return;
                    } else if (t[6].equals("X")) {
                        this.marcarMaquina(2);
                        return;
                    } else if (t[7].equals("X")) {
                        this.marcarMaquina(1);
                        return;
                    }
                } else if (t[5].equals("X")) {
                    if (t[8].equals("X")) {
                        this.marcarMaquina(2);
                        return;
                    }
                } else if (t[6].equals("X")) {
                    if (t[7].equals("X")) {
                        this.marcarMaquina(8);
                        return;
                    } else {
                        this.marcarMaquina(7);
                        return;
                    }
                } else if (t[7].equals("X")) {
                    this.marcarMaquina(6);
                    return;
                }
                // Armação
                if (t[0].equals("O")) {
                    if (t[2].equals("") && t[1].equals("")) {
                        this.marcarMaquina(2);
                    } else {
                        this.marcarMaquina(6);
                    }
                } else if (t[0].equals("") && t[8].equals("")) {
                    if (t[5].equals("X") || t[7].equals("X")) {
                        this.marcarMaquina(8);
                    } else {
                        this.marcarMaquina(0);
                    }

                } else {
                    this.marcarMaquina(2);
                }
                break;
            case 3:
                // Ataque
                if (t[0].equals("O")) {
                    if (t[1].equals("O") && t[2].equals("")) {
                        this.marcarMaquina(2);
                    } else if (t[2].equals("O") && t[1].equals("")) {
                        this.marcarMaquina(1);
                    } else if (t[3].equals("O") && t[6].equals("")) {
                        this.marcarMaquina(6);
                    } else if (t[6].equals("O") && t[3].equals("")) {
                        this.marcarMaquina(3);
                    } else if (t[4].equals("O") && t[8].equals("")) {
                        this.marcarMaquina(8);
                    }
                    // Defesa
                    if (t[4].equals("X")) {
                        if (t[1].equals("X") && t[7].equals("")) {
                            this.marcarMaquina(7);
                        } else if (t[7].equals("X") && t[1].equals("")) {
                            this.marcarMaquina(1);
                        } else if (t[2].equals("X") && t[6].equals("")) {
                            this.marcarMaquina(6);
                        } else if (t[6].equals("X") && t[2].equals("")) {
                            this.marcarMaquina(2);
                        } else if (t[5].equals("X") && t[3].equals("")) {
                            this.marcarMaquina(3);
                        } else if (t[3].equals("X") && t[5].equals("")) {
                            this.marcarMaquina(5);
                        }
                    }else{
                        if (t[2].equals("X") && t[8].equals("X") && t[5].equals("")) {
                            this.marcarMaquina(5);
                        } else if (t[2].equals("X") && t[5].equals("X") && t[8].equals("")) {
                            this.marcarMaquina(8);
                        } else if (t[5].equals("X") && t[8].equals("X") && t[2].equals("")) {
                            this.marcarMaquina(2);
                        } else if (t[6].equals("X") && t[7].equals("X") && t[8].equals("")) {
                            this.marcarMaquina(8);
                        } else if (t[6].equals("X") && t[8].equals("X") && t[7].equals("")) {
                            this.marcarMaquina(7);
                        } else if (t[7].equals("X") && t[8].equals("X") && t[6].equals("")) {
                            this.marcarMaquina(6);
                        }
                    }
                    // Armação
                } else {
                    if (t[1].equals("O") && t[7].equals("")) {
                        this.marcarMaquina(7);
                    } else if (t[7].equals("O") && t[1].equals("")) {
                        this.marcarMaquina(1);
                    } else if (t[2].equals("O") && t[6].equals("")) {
                        this.marcarMaquina(6);
                    } else if (t[6].equals("O") && t[2].equals("")) {
                        this.marcarMaquina(2);
                    } else if (t[5].equals("O") && t[3].equals("")) {
                        this.marcarMaquina(3);
                    } else if (t[3].equals("O") && t[5].equals("")) {
                        this.marcarMaquina(5);
                    }
                    if (t[2].equals("O")) {
                        if (t[0].equals("X") && t[3].equals("X") && t[6].equals("")) {
                            this.marcarMaquina(6);
                        } else if (t[0].equals("X") && t[6].equals("X") && t[3].equals("")) {
                            this.marcarMaquina(3);
                        } else if (t[3].equals("X") && t[6].equals("X") && t[0].equals("")) {
                            this.marcarMaquina(0);
                        } else if (t[6].equals("X") && t[7].equals("X") && t[8].equals("")) {
                            this.marcarMaquina(8);
                        } else if (t[6].equals("X") && t[8].equals("X") && t[7].equals("")) {
                            this.marcarMaquina(7);
                        } else if (t[7].equals("X") && t[8].equals("X") && t[6].equals("")) {
                            this.marcarMaquina(6);
                        }
                    } else if (t[6].equals("O")) {
                        if (t[2].equals("X") && t[8].equals("X") && t[5].equals("")) {
                            this.marcarMaquina(5);
                        } else if (t[2].equals("X") && t[5].equals("X") && t[8].equals("")) {
                            this.marcarMaquina(8);
                        } else if (t[5].equals("X") && t[8].equals("X") && t[2].equals("")) {
                            this.marcarMaquina(2);
                        } else if (t[0].equals("X") && t[1].equals("X") && t[2].equals("")) {
                            this.marcarMaquina(2);
                        } else if (t[0].equals("X") && t[2].equals("X") && t[1].equals("")) {
                            this.marcarMaquina(1);
                        } else if (t[1].equals("X") && t[2].equals("X") && t[0].equals("")) {
                            this.marcarMaquina(0);
                        }
                    } else if (t[8].equals("O")) {
                        if (t[0].equals("X") && t[3].equals("X") && t[6].equals("")) {
                            this.marcarMaquina(6);
                        } else if (t[0].equals("X") && t[6].equals("X") && t[3].equals("")) {
                            this.marcarMaquina(3);
                        } else if (t[3].equals("X") && t[6].equals("X") && t[0].equals("")) {
                            this.marcarMaquina(0);
                        } else if (t[0].equals("X") && t[1].equals("X") && t[2].equals("")) {
                            this.marcarMaquina(2);
                        } else if (t[0].equals("X") && t[2].equals("X") && t[1].equals("")) {
                            this.marcarMaquina(1);
                        } else if (t[1].equals("X") && t[2].equals("X") && t[0].equals("")) {
                            this.marcarMaquina(0);
                        }
                    }
                }

                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(330, 380));
        setMinimumSize(new java.awt.Dimension(330, 380));

        jButton1.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton1.setSize(new java.awt.Dimension(100, 100));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton2.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton2.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton2.setSize(new java.awt.Dimension(100, 100));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton3.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton3.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton3.setSize(new java.awt.Dimension(100, 100));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton4.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton4.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton4.setSize(new java.awt.Dimension(100, 100));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton5.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton5.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton5.setSize(new java.awt.Dimension(100, 100));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton6.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton6.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton6.setSize(new java.awt.Dimension(100, 100));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton7.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton7.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton7.setSize(new java.awt.Dimension(100, 100));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton8.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton8.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton8.setSize(new java.awt.Dimension(100, 100));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setMaximumSize(new java.awt.Dimension(100, 100));
        jButton9.setMinimumSize(new java.awt.Dimension(100, 100));
        jButton9.setPreferredSize(new java.awt.Dimension(100, 100));
        jButton9.setSize(new java.awt.Dimension(100, 100));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Reset");
        jButton10.setMaximumSize(new java.awt.Dimension(100, 30));
        jButton10.setMinimumSize(new java.awt.Dimension(100, 30));
        jButton10.setPreferredSize(new java.awt.Dimension(100, 30));
        jButton10.setSize(new java.awt.Dimension(100, 30));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.jogadaJogador(2, jButton2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.jogadaJogador(5, jButton5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.jogadaJogador(6, jButton6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.jogadaJogador(7, jButton7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.jogadaJogador(8, jButton8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        this.jogadaJogador(9, jButton9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jogadaJogador(1, jButton1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.jogadaJogador(3, jButton3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.jogadaJogador(4, jButton4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.turno = 0;
        this.t = new String[]{"", "", "", "", "", "", "", "", ""};
        this.jButton1.setIcon(null);
        this.jButton2.setIcon(null);
        this.jButton3.setIcon(null);
        this.jButton4.setIcon(null);
        this.jButton5.setIcon(null);
        this.jButton6.setIcon(null);
        this.jButton7.setIcon(null);
        this.jButton8.setIcon(null);
        this.jButton9.setIcon(null);

    }//GEN-LAST:event_jButton10ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    // End of variables declaration//GEN-END:variables
}
