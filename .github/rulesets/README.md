# Repository rulesets

These files are the repository's rulesets as code. GitHub does not apply them automatically; import each once
under **Settings → Rules → Rulesets → New ruleset → Import a ruleset**.

| File | Protects | Rules | Bypass |
| --- | --- | --- | --- |
| `main-protection.json` | default branch | no deletion, no force push | nobody |
| `main-pull-requests.json` | default branch | changes via pull request with green CI (job "Format, analysis, tests, build"), linear history | repository admins |
| `release-tags.json` | tags `v*` | tags cannot be deleted, moved or force-updated – F-Droid builds rely on them | nobody |

If the CI job is renamed, update the required status check in `main-pull-requests.json` and in the GitHub settings.
