soal1(a,b).

findLast(X,[X]).
findLast(X,[_|T]) :- findLast(X,T).

penjumlahan(X,0,X):- !.
penjumlahan(X,Y,Z) :- Z is X + Y, Z = 10002.

linearList([],[]).
linearList(H,[H]) :- not(is_list(H)).
linearList([H|T],Z) :- linearList(H,X), linearList(T,Y), append(X,Y,Z).

isTree(nil).
isTree(t(_,nil,nil)) :- !.
isTree(t(_,L,nil)) :- isTree(L).
isTree(t(_,nil,R)) :- isTree(R).
isTree(t(_,L,R)) :- isTree(L), isTree(R).

cBalTree(0,nil) :- !.
cBalTree(A,t(x,L,R)) :- A > 0, B is A - 1, C is B//2, D is B - C, distrib(C,D,NL,NR), cBalTree(NL,L), cBalTree(NR,R).
distrib(N,N,N,N).
distrib(A,B,A,B).
distrib(A,B,B,A).

simetris(nil).
simetris(t(_,L,R)) :- mirror(L,R).
mirror(nil,nil).
mirror(t(_,L1,R1),t(_,L2,R2)) :- mirror(L1,R2), mirror(R1,L2).

add(X,nil,t(X,nil,nil)).
add(X,t(Ro,L,R),t(Ro,L1,R)) :- X @< Ro, add(X,L,L1).
add(X,t(Ro,L,R),t(Ro,L,R1)) :- X @> Ro, add(X,R,R1).
construct(L,T) :- construct(L,T,nil).
construct([],T,T).
construct([N|Ns],T,T0) :- add(N,T0,T1), construct(Ns,T,T1).
tes_simetris(L) :- construct(L,T), simetris(T).

