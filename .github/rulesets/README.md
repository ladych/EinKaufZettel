# Repository rulesets

These files are the repository's rulesets as code. GitHub does not apply them automatically; import them once
under **Settings → Rules → Rulesets → New ruleset → Import a ruleset**.

| File | Protects | Rules |
| --- | --- | --- |
| `main.json` | default branch | no deletion, no force push, linear history, changes via pull request with green CI (job "Format, analysis, tests, build"); repository admins may bypass |
| `release-tags.json` | tags `v*` | tags cannot be deleted, moved or force-updated – F-Droid builds rely on them |

If the CI job is renamed, update the required status check in `main.json` and in the GitHub settings.
