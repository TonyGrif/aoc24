"""Template package for each days answers."""

import click


@click.command()
@click.option("--part", default=1, help="The part to solve for")
def main(part):
    """Main driver of package."""
    if part == 1:
        click.echo("Hello from aoc24 part 1!")
    elif part == 2:
        click.echo("Hello from aoc24 part 2!")


if __name__ == "__main__":
    main()
