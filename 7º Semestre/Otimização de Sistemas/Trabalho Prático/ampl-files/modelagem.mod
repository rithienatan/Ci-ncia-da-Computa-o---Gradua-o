#vari�veis de decis�o
param n;
param MaxTemp;

set I := {1..n};

param HoraCurso {I} >= 0;
param Necessidade {I} binary;

var Conclusao {I} binary;

#fun��o objetivo
maximize z: sum {i in I} Conclusao[i];

#restri��es
s.t. Constraint:
	sum {i in I} Conclusao[i]*HoraCurso[i] <= MaxTemp;

s.t. IS_NECESSARY {i in I: Necessidade[i] = 1}:
	Conclusao[i] = 1;