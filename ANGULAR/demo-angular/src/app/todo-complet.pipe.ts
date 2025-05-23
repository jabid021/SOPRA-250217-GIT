import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoComplet',
  standalone: false
})
export class TodoCompletPipe implements PipeTransform {
  transform(value: unknown, ...args: unknown[]): string {
    console.log("valeur ici", value);
    console.log("args ici", args);

    // Vérifier le contenu de args
    // SI le contenu de args est "couleur", alors on retournera une couleur
    // Couleur rouge hsl(341 79% 53%)
    // Couleur verte hsl(153 48% 49%)
    // SINON, on retourne le texte terminé ou pas terminé

    // Avec la couleur, modifier le style couleur de la ligne ou la colonne

    if (args.length > 0 && args[0] === "couleur") {
      if (value) {
        return "hsl(153 48% 49%)";
      }

      return "hsl(341 79% 53%)";
    }

    if (value) {
      return "Terminé !";
    }

    return "Non terminé";
  }
}
